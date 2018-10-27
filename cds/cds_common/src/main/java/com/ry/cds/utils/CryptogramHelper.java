package com.ry.cds.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.mockito.cglib.beans.BeanMap;

import com.ry.cds.user.bo.DocumentPrintOutput;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 3DES加密解密工具类
 * 
 * @author 幸仁强
 * @createtime 2018-2-12
 *
 */
public class CryptogramHelper {
	private static final String DESEDE = "desede";

	// 3DESECB加密,key必须是长度大于等于 3*8 = 24 位哈
	public static String encryptThreeDESECB(final String src, final String key) throws Exception {
		// MessageDigest md5 = MessageDigest.getInstance("MD5");
		// BASE64Encoder baseEncoder = new BASE64Encoder();
		// String md5key = baseEncoder.encode(md5.digest(key.getBytes("UTF-8")));
		String reKey = Polish24ByteKey(key);
		final DESedeKeySpec dks = new DESedeKeySpec(reKey.getBytes("UTF-8"));
		final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DESEDE);
		final SecretKey securekey = keyFactory.generateSecret(dks);
		final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, securekey);
		final byte[] b = cipher.doFinal(src.getBytes());
		final BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(b).replaceAll("\r", "").replaceAll("\n", "");

	}

	// 3DESECB解密,key必须是长度大于等于 3*8 = 24 位哈
	public static String decryptThreeDESECB(final String src, final String key) throws Exception {
		// MessageDigest md5 = MessageDigest.getInstance("MD5");
		// BASE64Encoder baseEncoder = new BASE64Encoder();
		// String md5key = baseEncoder.encode(md5.digest(key.getBytes("UTF-8")));
		// --通过base64,将字符串转成byte数组
		String reKey = Polish24ByteKey(key);
		final BASE64Decoder decoder = new BASE64Decoder();
		final byte[] bytesrc = decoder.decodeBuffer(src);
		// --解密的key
		final DESedeKeySpec dks = new DESedeKeySpec(reKey.getBytes("UTF-8"));
		final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DESEDE);
		final SecretKey securekey = keyFactory.generateSecret(dks);
		// --Chipher对象解密
		final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, securekey);
		final byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}

	private static String Polish24ByteKey(String key) {
		String returnkey = key;
		if (key.length() < 24) {
			for (int i = 1; i <= (24 - key.length()); i++) {
				returnkey = returnkey + i;
			}
		}
		return returnkey;
	}

	/**
	 * 获取利用反射获取类里面的值和名称
	 *
	 * @param obj
	 * @return
	 * @throws IllegalAccessException
	 */
	public static Map<String, String> objectToMap(Object obj) throws IllegalAccessException {
		Map<String, String> map = new HashMap<String, String>();
		Class<?> clazz = obj.getClass();
		System.out.println(clazz);
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object value = field.get(obj);
			if (StringUtils.isBlank(String.valueOf(value))) {
				continue;
			}
			map.put(fieldName, String.valueOf(value));
		}
		return map;
	}

	/**
	 * 实体类转换成map
	 * 
	 * @param bean
	 * @return
	 */
	public static <T> Map<String, String> beanToMap(T bean) {
		Map<String, String> map = new HashMap<String, String>();
		if (bean != null) {
			BeanMap beanMap = BeanMap.create(bean);
			for (Object key : beanMap.keySet()) {
				if (null == beanMap.get(key)) {
					continue;
				}
				map.put(key + "", String.valueOf(beanMap.get(key)));
			}
		}
		return map;
	}

	/**
	 * 方法描述:签名字符串
	 * 
	 * @param params
	 *            需要签名的参数
	 * @param secret
	 *            签名密钥
	 * @return
	 */
	public static String sign(Map<String, String> params, String secret) {
		StringBuilder valueSb = new StringBuilder();
		// 将参数以参数名的字典升序排序
		Map<String, String> sortParams = new TreeMap<String, String>(params);
		Set<Entry<String, String>> entrys = sortParams.entrySet();
		// 遍历排序的字典,并拼接key1=value1&key2=value2......格式
		for (Entry<String, String> entry : entrys) {
			valueSb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		valueSb.append("key=").append(secret);
		return md5(valueSb.toString());
	}

	/**
	 * 方法描述:将字符串MD5加码 生成32位md5码
	 * 
	 * @param inStr
	 * @return
	 */
	public static String md5(String inStr) {
		try {
			return DigestUtils.md5Hex(inStr.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5签名过程中出现错误");
		}
	}

	public static void main(String[] args) throws Exception {
		DocumentPrintOutput output = new DocumentPrintOutput();
		output.setComfrimResult("3");
		output.setErrorCode("4");
		output.setErrorMsg("5");
		output.setFreezeAmount(6);
		output.setPrintScene("7");
		System.out.println(sign(beanToMap(output), "ccccc"));
		// System.out.println(encryptThreeDESECB("CDS-User;ruanyun;http://10.0.7.35:8091/pools",
		// CommonConst.DESKEY));
		// System.out.println(decryptThreeDESECB("KiBdnLreApCDdTkoUBaJ+vhw3aeL6tFRaWdt/tjXjPV8XKEhNP31DXMQUFae4p+6",
		// CommonConst.DESKEY));

		// System.out.println(encryptThreeDESECB("CDS-Print;ruanyun;http://10.0.7.35:8091/pools",
		// CommonConst.DESKEY));
		// System.out.println(decryptThreeDESECB("5AcxoXHRf81/ObuGJetTpOVaYWRZd79DC6pKmYrwp3n0suWgx3PtfzoLBzwue7zf",
		// CommonConst.DESKEY));

		// System.out.println(
		// decryptThreeDESECB("FMy1pQ72zyP6JsAC2nF7POphevQuyO5fQvLXbgs8N19Z8rfKQlsDhF4QzuUcbZijnS/uDaOa11k=",
		// "RuanYun_Motk_UserKey1234"));
		// ZYx+IOAt1WEAdxc1I2ghaWWDLiqCN6HVclzb38DApLzjltwTYrFGDzSoHLS6pK5im7YA5ZCdpYU=
		// qTZco2MC/zxHPjecyh+qCmaa5b+ucYtnyN1EC7g4fb9xEtqTz2QHNHUVCzFfTX3tG7YgETOi+Mg=

	}
}
