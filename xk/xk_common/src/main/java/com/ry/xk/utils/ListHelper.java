package com.ry.xk.utils;

import java.util.*;

/**
 * List工具类
 * 
 * @author 幸仁强
 * @createtime 2018-2-12
 */
public final class ListHelper {
	public interface IConvert<O, V> {
		// 转换方法
		V cover(O o);

		// 是否过滤
		boolean filter(O o);
	}

	public interface IMapConvert<O, K, V> {
		K getKey(O o);

		V getValue(O o);
	}

	/**
	 * 判断list是否为null或empty
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List list) {
		if (null == list || list.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 如果list中有值,则返回true
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(List list) {
		return !isEmpty(list);
	}

	/**
	 * 通过convert转换器过滤dataList,返回一个新的list
	 * @param dataList
	 * @param convert
	 * @return
	 */
	public static <O, V> List<V> convert2List(List<O> dataList, IConvert<O, V> convert) {
		List<V> list = new ArrayList<V>();
		if (isNotEmpty(dataList)) {
			for (O o : dataList) {
				if (!convert.filter(o)) {
					list.add(convert.cover(o));
				}
			}
		}
		return list;
	}
	
	/**
	 * 通常用来将dataList中的每个对象的某个属性作为key,某个属性作为value转为map键值对.如每个对象的id作为key,name作为value
	 * @param dataList
	 * @param convert
	 * @return
	 */
	public static <O, K, V> Map<K, V> convert2Map(List<O> dataList, IMapConvert<O, K, V> convert) {
		Map<K, V> map = new HashMap<K, V>();
		if (isNotEmpty(dataList)) {
			for (O o : dataList) {
				map.put(convert.getKey(o), convert.getValue(o));
			}
		}
		return map;
	}

	/**
	 * 将dataList中的每个对象的某个属性作为key,某个属性作为value转为map键值对.如果键有重复,则键不变,值进行追加,并用","号分隔
	 * @param dataList
	 * @param convert
	 * @return
	 */
	public static <O, K, V> Map<K, String> convert2AppendMap(List<O> dataList, IMapConvert<O, K, V> convert) {
		Map<K, String> map = new HashMap<K, String>();
		if (isNotEmpty(dataList)) {
			for (O o : dataList) {
				if (map.containsKey(convert.getKey(o))) {
					map.replace(convert.getKey(o),
							(map.get(convert.getKey(o)) + "," + String.valueOf(convert.getValue(o))));
				} else {
					map.put(convert.getKey(o), String.valueOf(convert.getValue(o)));
				}
			}
		}
		return map;
	}

	/**
	 * 每个key保存的是ArrayList,如果值为null,则保存new ArrayList
	 * @param dataList
	 * @param convert
	 * @return
	 */
	public static <O, K, V> Map<K, List<V>> group2Map(List<O> dataList, IMapConvert<O, K, V> convert) {
		Map<K, List<V>> map = new HashMap<K, List<V>>();
		if (isNotEmpty(dataList)) {
			List<V> temp = null;
			for (O o : dataList) {
				temp = map.get(convert.getKey(o));
				if (null == temp) {
					temp = new ArrayList<V>();
					map.put(convert.getKey(o), temp);
				}
				temp.add(convert.getValue(o));
			}
		}
		return map;
	}

	/**
	 * 将list转为字符串,用","号拼接
	 * @param list
	 * @return
	 */
	public static String list2Str(List<? extends Object> list) {
		if (isEmpty(list)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (Object o : list) {
			sb.append(String.valueOf(o)).append(",");
		}
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * 将list中的每个对象的某个属性进行拼接,并指定是否需要单引号
	 * @param list
	 * @param convert
	 * @param needQuote
	 * @return
	 */
	public static <O, V> String list2Str(List<O> list, IConvert<O, V> convert, boolean needQuote) {
		if (isEmpty(list)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		if (needQuote) {
			for (O o : list) {
				if (!convert.filter(o)) {
					sb.append("'").append(String.valueOf(convert.cover(o))).append("'").append(",");
				}

			}
		} else {
			for (O o : list) {
				if (!convert.filter(o)) {
					sb.append(String.valueOf(convert.cover(o))).append(",");
				}

			}
		}
		if (sb.length() > 1) {
			return sb.substring(0, sb.length() - 1);
		}
		return "";
	}

	/**
	 * 对集合进行去重
	 * @param list
	 * @param o
	 * @param <T>
	 * @return
	 */
	public static<T> List<T> removeRepeat(List<T> list,ReturnObject<T> o) {
		if(list == null){
			return new ArrayList<T>();
		}
		Set set = new HashSet();
		List newList = new  ArrayList();
		for (T cd:list) {
			if(set.add(o.compareEqual(cd))){
				newList.add(cd);
			}
		}
		return newList;
	}
}
