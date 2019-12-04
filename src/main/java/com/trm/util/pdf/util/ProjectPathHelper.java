package com.trm.util.pdf.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author zhaosimiao
 * @date 2018-8-9 11:13:36
 * 用来加载类classpath下的资源文件，属性文件等
 * getExtendResource(String relativePath)方法，可以使用../符号来加载classpath外部的资源。
 */
public class ProjectPathHelper {
	
	private static Log log = LogFactory.getLog(ProjectPathHelper.class);

	/**
	 * 加载Java类
	 * @param className 全限定类名
	 * @return
	 */
	public static Class<?> loadClass(String className) {
		try {
			return getClassLoader().loadClass(className);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("class not found '" + className + "'", e);
		}
	}

	/**
	 * 得到类加载器
	 * @return
	 */
	public static ClassLoader getClassLoader() {
		return ProjectPathHelper.class.getClassLoader();
	}

	/**
	 * 提供相对于classpath的资源路径，返回文件的输入流
	 * @param relativePath 必须传递资源的相对路径。是相对于classpath的路径 / 如果需要查找classpath外部的资源，需要使用../来查找
	 * @return 文件输入流
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static InputStream getStream(String relativePath) throws MalformedURLException, IOException {
		if (!relativePath.contains("../")) {
			return getClassLoader().getResourceAsStream(relativePath);
		} else {
			return ProjectPathHelper.getStreamByExtendResource(relativePath);
		}

	}

	/**
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static InputStream getStream(URL url) throws IOException {
		if (url != null) {
			return url.openStream();
		} else {
			return null;
		}
	}

	/**
	 * @param relativePath 必须传递资源的相对路径。是相对于classpath的路径 / 如果需要查找classpath外部的资源，需要使用../来查找
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static InputStream getStreamByExtendResource(String relativePath) throws MalformedURLException, IOException {
		return ProjectPathHelper.getStream(ProjectPathHelper.getExtendResource(relativePath));
	}

	/**
	 * 提供相对于classpath的资源路径，返回属性对象，它是一个散列表
	 * @param resource
	 * @return
	 */
	public static Properties getProperties(String resource) {
		Properties properties = new Properties();
		try {
			properties.load(getStream(resource));
		} catch (IOException e) {
			throw new RuntimeException("couldn't load properties file '" + resource + "'", e);
		}
		return properties;
	}

	/**
	 * 得到本Class所在的ClassLoader的Classpat的绝对路径， URL形式的
	 * @return
	 */
	public static String getAbsolutePathOfClassLoaderClassPath() {
		ProjectPathHelper.log.info(ProjectPathHelper.getClassLoader().getResource("").toString());
		return ProjectPathHelper.getClassLoader().getResource("").toString();

	}

	/**
	 * @param relativePath 必须传递资源的相对路径，是相对于classpath的路径。如果需要查找classpath外部的资源，需要使用../来查找
	 * @throws MalformedURLException
	 * @return资源的绝对URL
	 */
	public static URL getExtendResource(String relativePath) throws MalformedURLException {
		ProjectPathHelper.log.info("传入的相对路径：" + relativePath);
		// ClassLoaderUtil.log.info(Integer.valueOf(relativePath.indexOf("../")));
		if (!relativePath.contains("../")) {
			return ProjectPathHelper.getResource(relativePath);
		}
		String classPathAbsolutePath = ProjectPathHelper.getAbsolutePathOfClassLoaderClassPath();
		if (relativePath.substring(0, 1).equals("/")) {
			relativePath = relativePath.substring(1);
		}
		ProjectPathHelper.log.info(Integer.valueOf(relativePath.lastIndexOf("../")));

		String wildcardString = relativePath.substring(0, relativePath.lastIndexOf("../") + 3);
		relativePath = relativePath.substring(relativePath.lastIndexOf("../") + 3);
		int containSum = ProjectPathHelper.containSum(wildcardString, "../");
		classPathAbsolutePath = ProjectPathHelper.cutLastString(classPathAbsolutePath, "/", containSum);
		String resourceAbsolutePath = classPathAbsolutePath + relativePath;
		ProjectPathHelper.log.info("绝对路径：" + resourceAbsolutePath);
		URL resourceAbsoluteURL = new URL(resourceAbsolutePath);
		return resourceAbsoluteURL;
	}

	/**
	 * @return
	 * @paramsource
	 * @paramdest
	 */
	private static int containSum(String source, String dest) {
		int containSum = 0;
		int destLength = dest.length();
		while (source.contains(dest)) {
			containSum = containSum + 1;
			source = source.substring(destLength);
		}
		return containSum;
	}

	/**
	 * @return
	 * @param source
	 * @param dest
	 * @param num
	 */
	private static String cutLastString(String source, String dest, int num) {
		// String cutSource=null;
		for (int i = 0; i < num; i++) {
			source = source.substring(0, source.lastIndexOf(dest, source.length() - 2) + 1);
		}
		return source;
	}

	/**
	 * @return
	 * @paramresource
	 */
	public static URL getResource(String resource) {
		ProjectPathHelper.log.info("传入的相对于classpath的路径：" + resource);
		return ProjectPathHelper.getClassLoader().getResource(resource);
	}

	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		// ClassLoaderUtil.getExtendResource("../spring/dao.xml");
		// ClassLoaderUtil.getExtendResource("../../../src/log4j.properties");
		// ProjectPathHelper.getExtendResource("fonts/ping_fang_light.ttf");
		System.out.println(ProjectPathHelper.getExtendResource("fonts/ping_fang_light.ttf").toString());
	}

}