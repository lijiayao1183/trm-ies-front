package com.trm.util.pdf.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Maps;
import com.trm.util.pdf.PDFKit;
import com.trm.util.pdf.Exception.FreeMarkerException;
import com.trm.util.pdf.Exception.PDFException;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * @author zhaosimiao 2018-5-3 11:32:16
 * FREEMARKER 模板工具类
 */
public class FreeMarkerUtil {

    private static final String WINDOWS_SPLIT = "\\";

    private static final String UTF_8="UTF-8";

    private static Map<String,FileTemplateLoader> fileTemplateLoaderCache=Maps.newConcurrentMap();

    private static  Map<String,Configuration> configurationCache= Maps.newConcurrentMap();

    public static Configuration getConfiguration(String templateFilePath){
        if(null!=configurationCache.get(templateFilePath)){
            return configurationCache.get(templateFilePath);
        }
        Configuration config = new Configuration(Configuration.VERSION_2_3_25);
        config.setDefaultEncoding(UTF_8);
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        config.setLogTemplateExceptions(false);
        FileTemplateLoader fileTemplateLoader=null;
        if(null!=fileTemplateLoaderCache.get(templateFilePath)){
            fileTemplateLoader=fileTemplateLoaderCache.get(templateFilePath);
        }
        try {
            fileTemplateLoader=new FileTemplateLoader(new File(templateFilePath));
            fileTemplateLoaderCache.put(templateFilePath,fileTemplateLoader);
        } catch (IOException e) {
            throw new FreeMarkerException("fileTemplateLoader init error!",e);
        }
        config.setTemplateLoader(fileTemplateLoader);
        configurationCache.put(templateFilePath,config);
        return config;

    }


    /**
     * @description 获取模板
     */
    public static String getContent(String fileName, Object data) {
        String templatePath = getPDFTemplatePath(fileName);
        String templateFileName = getTemplateName(templatePath);
        String templateFilePath = getTemplatePath(templatePath);
        if (StringUtils.isEmpty(templatePath)) {
            throw new FreeMarkerException("templatePath can not be empty!");
        }
        try {
            Template template=getConfiguration(templateFilePath).getTemplate(templateFileName);
            StringWriter writer = new StringWriter();
            template.process(data, writer);
            writer.flush();
            return  writer.toString();
        } catch (Exception ex) {
            throw new FreeMarkerException("FreeMarkerUtil process fail", ex);
        }
    }

    private static String getTemplatePath(String templatePath) {
        if (StringUtils.isEmpty(templatePath)) {
            return "";
        }
        if (templatePath.contains(WINDOWS_SPLIT)) {
            return templatePath.substring(0, templatePath.lastIndexOf(WINDOWS_SPLIT));
        }
        return templatePath.substring(0, templatePath.lastIndexOf("/"));
    }

    private static String getTemplateName(String templatePath) {
        if (StringUtils.isEmpty(templatePath)) {
            return "";
        }
        if (templatePath.contains(WINDOWS_SPLIT)) {
            return templatePath.substring(templatePath.lastIndexOf(WINDOWS_SPLIT) + 1);
        }
        return templatePath.substring(templatePath.lastIndexOf("/") + 1);
    }

    /**
     * @param fileName PDF文件名
     * @return 匹配到的模板名
     * @description 获取PDF的模板路径,
     * 默认按照PDF文件名匹对应模板
     */
    public static String getPDFTemplatePath(String fileName) {
        String classpath = PDFKit.class.getClassLoader().getResource("").getPath();
        String templatePath = classpath + "/templates";
        File file = new File(templatePath);
        if (!file.isDirectory()) {
            throw new PDFException("PDF模板文件不存在,请检查templates文件夹!");
        }
        File matchTemplate = null;
        for (File f : file.listFiles()) {
            if (!f.isFile()) {
                continue;
            }
            String templateName = f.getName();
            // 指定字符串不存在则返回-1，存在则返回最后一次出现的索引
            if (templateName.lastIndexOf(".htm") == -1) {
                continue;
            }
            if (StringUtils.isEmpty(fileName)) {
                break;
            }
            templateName = templateName.substring(0, templateName.lastIndexOf("."));
            if (fileName.toLowerCase().contains(templateName.toLowerCase())) {
                matchTemplate = f;
                break;
            }
            
        }
        if (matchTemplate != null) {
            return matchTemplate.getAbsolutePath();
        }
		return templatePath;
    }


}
