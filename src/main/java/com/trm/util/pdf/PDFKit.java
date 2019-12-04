package com.trm.util.pdf;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactoryImp;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.net.FileRetrieve;
import com.itextpdf.tool.xml.net.ReadingProcessor;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.AbstractImageProvider;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.itextpdf.tool.xml.pipeline.html.ImageProvider;
import com.itextpdf.tool.xml.pipeline.html.NoImageProviderException;
import com.trm.util.pdf.Exception.PDFException;
import com.trm.util.pdf.builder.HeaderFooterBuilder;
import com.trm.util.pdf.builder.PDFBuilder;
import com.trm.util.pdf.util.FreeMarkerUtil;

public class PDFKit {

	// PDF页眉、页脚定制工具
	private HeaderFooterBuilder headerFooterBuilder;
	private String saveFilePath;

	/**
	 * @description 导出pdf到文件
	 * @param fileName
	 *            输出PDF文件名
	 * @param data
	 *            模板所需要的数据
	 *
	 */
	public String exportToFile(String fileName, Object data) {

		String htmlData = FreeMarkerUtil.getContent(fileName, data);
		if (StringUtils.isEmpty(saveFilePath)) {
			saveFilePath = getDefaultSavePath(fileName);
		}
		File file = new File(saveFilePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		FileOutputStream outputStream = null;
		try {
			// 设置输出路径
			outputStream = new FileOutputStream(saveFilePath);
			// 设置文档大小
			Document document = new Document(PageSize.A4, 30, 30, 60, 60);
			document.getPageSize().getWidth();
			
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			// 设置页眉页脚
			PDFBuilder builder = new PDFBuilder(headerFooterBuilder, data);
			builder.setPresentFontSize(10);
			writer.setPageEvent(builder);

			// 输出为PDF文件
			convertToPDF(writer, document, htmlData);
		} catch (Exception ex) {
			throw new PDFException("PDF export to File fail", ex);
		} finally {
			IOUtils.closeQuietly(outputStream);
		}
		return saveFilePath;

	}

	/**
	 * 生成PDF到输出流中（ServletOutputStream用于下载PDF）
	 * 
	 * @param ftlPath
	 *            ftl模板文件的路径（不含文件名）
	 * @param data
	 *            输入到FTL中的数据
	 * @param response
	 *            HttpServletResponse
	 * @return
	 */
	public OutputStream exportToResponse(String ftlPath, Object data, HttpServletResponse response) {

		String html = FreeMarkerUtil.getContent(ftlPath, data);

		try {
			OutputStream out = null;
			// ITextRenderer render = null;
			out = response.getOutputStream();
			// 设置文档大小
			Document document = new Document(PageSize.A4);
			PdfWriter writer = PdfWriter.getInstance(document, out);
			// 设置页眉页脚
			PDFBuilder builder = new PDFBuilder(headerFooterBuilder, data);

			writer.setPageEvent(builder);
			// 输出为PDF文件
			convertToPDF(writer, document, html);
			return out;
		} catch (Exception ex) {
			throw new PDFException("PDF export to response fail", ex);
		}

	}

	/**
	 * @description PDF文件生成
	 */
	private void convertToPDF(PdfWriter writer, Document document, String htmlString) {
		// 获取字体路径
		// String fontPath=getFontPath();

		document.open();
		try {

			HtmlPipelineContext htmlContext = new HtmlPipelineContext(new CssAppliersImpl(new XMLWorkerFontProvider() {
				@Override
				public Font getFont(String fontname, String encoding, float size, final int style) {
					Font font = null;
					BaseFont bf = null;
					try {
						// 字体
						String fontCn = getChineseFont();
						bf = BaseFont.createFont(fontCn + ",1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
						font = new Font(bf, size, style);
					} catch (DocumentException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					return font;
				}
			})) {
				@Override
				public HtmlPipelineContext clone() throws CloneNotSupportedException {
					HtmlPipelineContext context = super.clone();
					try {
						ImageProvider imageProvider = this.getImageProvider();
						context.setImageProvider(imageProvider);
					} catch (NoImageProviderException e) {
					}
					return context;
				}
			};

			// 图片解析
			htmlContext.setImageProvider(new AbstractImageProvider() {

				// String rootPath = servletContext.getRealPath("/");

				@Override
				public String getImageRootPath() {
					return "";
				}

				@Override
				public Image retrieve(String src) {
					if (StringUtils.isEmpty(src)) {
						return null;
					}
					try {
						// String imageFilePath = new File(rootPath,
						// src).toURI().toString();
						Image image = Image.getInstance(src);
						image.setAbsolutePosition(400, 400);
						if (image != null) {
							store(src, image);
							return image;
						}
					} catch (Throwable e) {
						e.printStackTrace();
					}
					return super.retrieve(src);
				}
			});
			htmlContext.setAcceptUnknown(true).autoBookmark(true).setTagFactory(Tags.getHtmlTagProcessorFactory());

			// css解析
			CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
			cssResolver.setFileRetrieve(new FileRetrieve() {
				@Override
				public void processFromStream(InputStream in, ReadingProcessor processor) throws IOException {
					try (InputStreamReader reader = new InputStreamReader(in, "UTF-8")) {
						int i = -1;
						while (-1 != (i = reader.read())) {
							processor.process(i);
						}
					} catch (Throwable e) {
					}
				}

				// 解析href
				@Override
				public void processFromHref(String href, ReadingProcessor processor) throws IOException {
					// InputStream is =
					// servletContext.getResourceAsStream(href);
					URL url = new URL(href);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.setConnectTimeout(5 * 1000);
					InputStream is = conn.getInputStream();

					try (InputStreamReader reader = new InputStreamReader(is, "utf-8")) {
						int i = -1;
						while (-1 != (i = reader.read())) {
							processor.process(i);
						}
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			});

			HtmlPipeline htmlPipeline = new HtmlPipeline(htmlContext, new PdfWriterPipeline(document, writer));
			Pipeline<?> pipeline = new CssResolverPipeline(cssResolver, htmlPipeline);
			XMLWorker worker = null;
			worker = new XMLWorker(pipeline, true);
			XMLParser parser = new XMLParser(true, worker, Charset.forName("UTF-8"));
			try (InputStream inputStream = new ByteArrayInputStream(htmlString.getBytes("UTF-8"))) {
				parser.parse(inputStream, Charset.forName("UTF-8"));
			}
			// XMLWorkerHelper.getInstance().parseXHtml(writer, document, null,
			// new ByteArrayInputStream(htmlString.getBytes("UTF-8")),
			// Charset.forName("UTF-8"), new MyFont());
			/*
			 * (writer,document, new
			 * ByteArrayInputStream(htmlString.getBytes("UTF-8")), null,
			 * Charset.forName("UTF-8"),new MyFont())
			 */;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PDFException("PDF文件生成异常", e);
		} finally {
			document.close();
		}

	}

	/**
	 * @description 创建默认保存路径
	 */
	private String getDefaultSavePath(String fileName) {
		String classpath = PDFKit.class.getClassLoader().getResource("").getPath();
		String saveFilePath = classpath + "pdf/" + fileName;
		File f = new File(saveFilePath);
		if (!f.getParentFile().exists()) {
			f.mkdirs();
		}
		return saveFilePath;
	}

	/**
	 * @description 获取字体设置路径
	 */
	public static String getFontPath() {
		String classpath = PDFKit.class.getClassLoader().getResource("").getPath();
		String fontpath = classpath + "fonts";
		return fontpath;
	}

	public HeaderFooterBuilder getHeaderFooterBuilder() {
		return headerFooterBuilder;
	}

	public void setHeaderFooterBuilder(HeaderFooterBuilder headerFooterBuilder) {
		this.headerFooterBuilder = headerFooterBuilder;
	}

	public String getSaveFilePath() {
		return saveFilePath;
	}

	public void setSaveFilePath(String saveFilePath) {
		this.saveFilePath = saveFilePath;
	}

	class MyFont extends FontFactoryImp {
		BaseFont baseFont = null;

		public MyFont() {
			try {
				baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
						BaseFont.NOT_EMBEDDED);
			} catch (com.itextpdf.text.DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public com.itextpdf.text.Font getFont(String fontName, String encoding, boolean embedded, float size, int style,
				BaseColor color, boolean cached) {
			return new com.itextpdf.text.Font(baseFont, 9, com.itextpdf.text.Font.NORMAL);
		}
	}

	/**
	 * 获取中文字体位置
	 * 
	 * @return
	 */

	private String getChineseFont() {
		String chineseFont = null;
		chineseFont = PDFKit.class.getClassLoader().getResource("").getPath() + "fonts/SIMSUN.TTC";
		chineseFont.substring(1);
		if (!new File(chineseFont).exists()) {
			throw new RuntimeException("字体文件不存在,影响导出pdf中文显示！" + chineseFont);
		}
		return chineseFont;
	}

}