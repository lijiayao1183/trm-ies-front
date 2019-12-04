package com.trm.util.pdf.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 随机文件名生成类
 * 
 * @author zhaosimiao 2018-5-4 10:57:41
 */
public class RandomUtil {
	
	public static String getRandomFileName() {

		SimpleDateFormat simpleDateFormat;

		simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();

		String datestr = simpleDateFormat.format(date);
		
		//System.out.println("datestr" + datestr);

		Random random = new Random();

		int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
		
		return datestr+rannum;// 当前时间
	}

	public static void main(String[] args) {

		String fileName = RandomUtil.getRandomFileName();

		System.out.println(fileName);
	}
}
