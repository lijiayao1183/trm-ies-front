package com.trm.util.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.trm.util.pdf.builder.HeaderFooterBuilder;

/**
 * @author zhaosimiao 2018-5-3 11:18:02
 * 页眉页脚定制工具
 */
public class PDFHeaderFooter implements HeaderFooterBuilder {
	
    /**
     * @param writer   PDF编写类
     * @param document PDF文档对象
     * @param data     业务数据
     * @param font     字体设置
     * @param template PDF模板
     * @description PDF页脚设置类
     */
    public void writeFooter(PdfWriter writer,
                            Document document,
                            Object data,
                            Font font,
                            PdfTemplate template) {
        if (data == null) {
            return;
        }
        int currentPageNumber = writer.getCurrentPageNumber();
        /*float width = writer.getPageSize().getWidth();
        float height = writer.getPageSize().getHeight();
        int pageS = writer.getPageNumber();*/
        int currentPage = currentPageNumber;
        /*if (currentPage <= 0) {
            return;
        }*/
        Phrase footer1 = new Phrase("资料下载", font);
        Phrase footer2 = new Phrase(currentPage + "/", font);

        PdfContentByte cb = writer.getDirectContent();
        ColumnText.showTextAligned(
                cb,
                Element.ALIGN_LEFT,
                footer1,
                (document.left() + 10),
                document.bottom() - 20,
                0);
        ColumnText.showTextAligned(
                cb,
                Element.ALIGN_RIGHT,
                footer2,
                (document.right() - 30),
                document.bottom() - 20, 0);

        //设置模板位置
        cb.addTemplate(template, document.right() - 30, document.bottom() - 20);

    }

    /**
     * @param writer   PDF编写类
     * @param document PDF文档对象
     * @param data     业务数据
     * @param font     字体设置
     * @param template PDF模板
     * @description PDF页头设置类
     */
    public void writeHeader(PdfWriter writer,
                            Document document,
                            Object data,
                            Font font,
                            PdfTemplate template) {

        ColumnText.showTextAligned(
                writer.getDirectContent(),
                Element.ALIGN_LEFT,
                new Phrase("陕西军民融合科技创新资源开放共享服务平台", font),
                document.left(),
                document.top() + 6, 0);

    }


    /**
     * @param writer   PDF编写类
     * @param document PDF文档对象
     * @param data     业务数据
     * @description 页头、页眉设置的模板替换类
     */
    public String getReplaceOfTemplate(PdfWriter writer, Document document, Object data) {
        int total = writer.getPageNumber() - 1;
        return total + "";
    }

}
