package com.ry.cds.amqp.bo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.ry.cds.common.CommonConst;

/**
 * PDF转PRN MQ消息实体类
 * 
 * @author 幸仁强
 *
 */
@Component
public class PDFConvertPRN implements Serializable, IAmqpStoredObject {
	private String documentID;
	private String pdfUrl;

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public String getPdfUrl() {
		return pdfUrl;
	}

	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	private static final long serialVersionUID = 1L;
	private String queueName = CommonConst.PDFCONVERTPRNQUEUE;

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	@Override
	public String getQueueName() {
		return this.queueName;
	}

}