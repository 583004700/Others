package com.ry.xk.test;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfOrderdNPiHdpe;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.Order;
import wcf.omcorderwrapperservice.org.tempuri.OMCOrderWrapperService;

/**
 * <描述类的作用>
 * 
 * @ClassName: A
 * @author 幸仁强
 * @date 2018年5月16日
 */

public class OMCOrderWrapperServiceTest
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
        OMCOrderWrapperService service = new OMCOrderWrapperService();
        ServiceResultOfOrderdNPiHdpe result = service.getWSHttpBindingIOMCOrderWrapperService().getOrderById(1L);
        Order order = result.getEntity().getValue();
        System.out.println(order.getOrderCreateUserId());

    }
}
