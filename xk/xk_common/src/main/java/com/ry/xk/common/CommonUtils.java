package com.ry.xk.common;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.validation.ObjectError;

import com.ry.xk.utils.ListHelper;
import com.ry.xk.utils.ListHelper.IConvert;

public class CommonUtils {
	/**
	 * 获取所有校验错误信息
	 * 
	 * @param allErrors
	 * @return
	 */
	public static String getAllValidateError(List<ObjectError> allErrors) {
		return ListHelper.list2Str(allErrors, new IConvert<ObjectError, String>() {
			@Override
			public String cover(ObjectError o) {
				return o.getDefaultMessage();
			}

			@Override
			public boolean filter(ObjectError o) {
				return false;
			}
		}, false);
	}

	/**
	 * P为前端置灰的数据，N为可打印的数据 1-待打印、2 -已创建打印任务、3- 打印成功（不显示）、 4- 打印失败
	 * 
	 * @param status
	 * @return
	 */
	public static String printStatusMapping(String status) {
		if ("1".equals(status)) {
			return "N";
		}
		if ("2".equals(status)) {
			return "P";
		}
		if ("4".equals(status)) {
			return "P";
		}
		return "P";
	}

	/**
	 * 金额转换，由毫转换成元，保留两位小数，4舍5入
	 * 
	 * @param amount
	 * @return
	 */
	public static double amountConvertYuan(long amount) {
		BigDecimal bigDecimal = BigDecimal.valueOf(amount).divide(new BigDecimal(10000), 2, BigDecimal.ROUND_HALF_UP);
		return bigDecimal.doubleValue();
	}

	/**
	 * 金额转换，由元转换成毫
	 * 
	 * @param amount
	 * @return
	 */
	public static long amountConvertHao(double amount) {
		BigDecimal bigDecimal = BigDecimal.valueOf(amount).multiply(new BigDecimal(10000));
		return bigDecimal.longValue();
	}
}
