package com.ry.cds.utils;

import java.io.File;
import java.util.Calendar;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * 文件工具类
 * 
 * @author 幸仁强
 * @createtime 2018-2-12
 */
public final class FileUtil {

	private FileUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 判断文件名是否是被允许的类型
	 * @param fileName
	 * @param allowStr
	 * @return
	 */
	public static boolean isAllowFile(String fileName, String allowStr) {
		if (StringUtils.isNotBlank(fileName) && StringUtils.isNotBlank(allowStr)) {
			int index = fileName.lastIndexOf(".");
			if (index >= 0) {
				String fileType = fileName.substring(index + 1);
				if (StringUtils.isNotBlank(fileType)) {
					return allowStr.toLowerCase().indexOf(fileType.toLowerCase()) >= 0;
				}
			}
		}
		return false;
	}
	
	/**
	 * 得到文件名不包含文件拓展名
	 * @param fileName
	 * @return
	 */
	public static String getFileNameWithoutExtension(String fileName) {

		return fileName.substring(fileName.lastIndexOf("/") + 1, fileName.lastIndexOf("."));
	}
	
	/**
	 * 得到文件的拓展名
	 * @param fileName
	 * @return
	 */
	public static String getFileType(String fileName) {
		if (StringUtils.isNotBlank(fileName)) {
			int index = fileName.lastIndexOf(".");
			if (index >= 0) {
				return fileName.substring(index + 1);
			}
		}
		return "";
	}

	/**
	 * 得到不唯一的文件名
	 * @param fileName
	 * @return
	 */
	public static String getUniqueFileName(String fileName) {
		String fileType = getFileType(fileName);
		StringBuffer sb = new StringBuffer("");
		sb.append(getGUID()).append(".").append(fileType);
		return sb.toString();
	}

	public static String getGUID() {
		Random rand = new Random();// 生成5位随机数
		int rannum = (int) (rand.nextDouble() * (99999 - 10000 + 1)) + 10000;
		Calendar calCurrent = Calendar.getInstance();
		long zone = calCurrent.getTimeInMillis();
		return zone + String.valueOf(rannum);
	}

	public static void main(String[] args) throws Exception {
		File folder = new File("D:\\logback");
		File[] files = folder.listFiles();
		for (File file : files) {
			System.out.println(file.getPath());
		}

	}
}
