package com.ry.xk.test;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult;
import wcf.wxpayservice.org.tempuri.WxPayService;

/**
 * <描述类的作用>
 * 
 * @ClassName: A
 * @author 幸仁强
 * @date 2018年5月16日
 */

public class WxPayServiceTest
{

    /**
     * <描述方法的作用>
     * 
     * @Title: main
     * @author 幸仁强
     * @param args
     * @throws ServiceException
     * @throws RemoteException
     * @throws MalformedURLException
     */

    public static void main(String[] args)
        throws Exception
    {
        WxPayService service = new WxPayService();
        ServiceResult result = service.getWSHttpBindingIWxPayService().noticeOrderTradeSuccess("1000000");
        System.out.println(result.isIsSucceed());
    }
}
