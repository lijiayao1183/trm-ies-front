package com.trm.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
/**
 * @author <a href="mailto:humorbeau@163.com">胡渊博</a>
 * @date 2016年12月17日
 * @version 1.0
 */
public class MD5Utils {

	private static Md5PasswordEncoder instance;

	private MD5Utils (){}

	/**
	 * 通过单例获取Md5PasswordEncoder
	 * @return
	 */
	public static synchronized Md5PasswordEncoder getInstance() {
		if (instance == null) {
			instance = new Md5PasswordEncoder();
		}
		return instance;
	}
}
