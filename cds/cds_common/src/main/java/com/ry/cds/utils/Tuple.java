package com.ry.cds.utils;

/**
 * 封装数组的操作,防止越界等
 * @author 幸仁强
 *
 * @param <A>
 */
public class Tuple<A> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <A> Tuple make(A... args) {
		return new Tuple(args);
	}

	private A[] items;

	private Tuple(A[] items) {
		this.items = items;
	}
	
	/**
	 * 通过index得到当前对象中维护的items
	 * @param index
	 * @return
	 */
	public A _(int index) {
		if (index < 0 || items == null || index > items.length - 1) {
			return null;
		}
		return items[index];
	}
}