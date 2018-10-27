package com.ry.cds.user.service;

import com.ry.cds.user.bo.DocumentPrintInput;
import com.ry.cds.user.bo.DocumentPrintOutput;

/**
 * 用户账户业务接口
 * 
 * @author 幸仁强
 *
 */
public interface IUserAccountService {
	/**
	 * 用户选择需要打印的文档后触发的打印请求
	 * 
	 * @param documentPrintInput
	 * @return
	 */
	public DocumentPrintOutput print(DocumentPrintInput documentPrintInput) throws Exception;
}
