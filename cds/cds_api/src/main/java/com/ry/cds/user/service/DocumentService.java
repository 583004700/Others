package com.ry.cds.user.service;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.MQSender;
import com.ry.cds.amqp.bo.PDFConvertPRN;
import com.ry.cds.common.CommonConst;
import com.ry.cds.user.bo.Document;
import com.ry.cds.user.bo.DocumentPrintRecord;
import com.ry.cds.user.bo.ResultBase;
import com.ry.cds.user.bo.SyncDocumentInput;
import com.ry.cds.user.bo.SyncDocumentOutput;
import com.ry.cds.user.bo.UpdateDocumentInput;
import com.ry.cds.user.bo.User;
import com.ry.cds.user.dao.IDocumentDao;
import com.ry.cds.user.dao.IUserDao;
import com.ry.cds.utils.CryptogramHelper;

@Service
public class DocumentService implements IDocumentService {
	private static final Logger log = LoggerFactory.getLogger(DocumentService.class);
	@Autowired
	IDocumentDao documentDao;

	@Autowired
	IUserDao userDao;

	@Autowired
	MQSender mqSender;

	@Override
	public Document get(long documentID) throws Exception {
		return documentDao.get(documentID);
	}

	@Override
	public long insert(Document document) throws Exception {
		return documentDao.insert(document);
	}

	@Override
	public int update(Document document) throws Exception {
		return documentDao.update(document);
	}

	@Override
	public SyncDocumentOutput synchronous(SyncDocumentInput syncDocumentInput) throws Exception {
		SyncDocumentOutput syncDocumentOutput = check(syncDocumentInput);
		if (null != syncDocumentOutput) {
			return syncDocumentOutput;
		}
		Document document = fitDocument(syncDocumentInput);
		long documentID = this.insert(document);
		if (documentID > 0) {
			PDFConvertPRN mqEntity = new PDFConvertPRN();
			mqEntity.setDocumentID(CryptogramHelper.encryptThreeDESECB(String.valueOf(documentID), CommonConst.DESKEY));
			String pdfUrl = document.getPdfUrl();
			StringBuffer sb = new StringBuffer();
			sb.append(pdfUrl.substring(0, pdfUrl.indexOf(CommonConst.OSS_URL_SUFFIX)));
			sb.append(CommonConst.OSS_INTERNAL_URL_SECTION);
			sb.append(pdfUrl.substring(pdfUrl.indexOf(CommonConst.OSS_URL_SUFFIX), pdfUrl.length()));
			mqEntity.setPdfUrl(sb.toString());
			mqSender.send(mqEntity);
			return new SyncDocumentOutput(CommonConst.RESULT_Y, true, null, null);
		} else {
			log.error(MessageFormat.format("文档同步失败:sourceCode={0},documentTypeID={1}",
					syncDocumentInput.getDocumentId(), syncDocumentInput.getDocumentType()));
			return new SyncDocumentOutput(CommonConst.RESULT_N, false, null, "文档同步失败");
		}
	}

	/**
	 * BO装配
	 * 
	 * @param syncDocumentInput
	 * @return
	 * @throws Exception
	 */
	private Document fitDocument(SyncDocumentInput syncDocumentInput) throws Exception {
		Document document = new Document();
		document.setDocumentTypeID(syncDocumentInput.getDocumentType());
		document.setUserID(userDao.getByUserCode(syncDocumentInput.getUserCode()).getUserID());
		document.setSourceCode(syncDocumentInput.getDocumentId());
		document.setSourceUrl(syncDocumentInput.getDownloadUrl());
		document.setPdfUrl(syncDocumentInput.getDownloadUrl());
		document.setPageCount(syncDocumentInput.getDocumentPageCount());
		document.setPrintedPageCount(0);
		if (StringUtils.isNotBlank(syncDocumentInput.getSubject())) {
			document.setCourseID(Integer.parseInt(syncDocumentInput.getSubject()));
		}
		document.setDocumentName(syncDocumentInput.getDocumentName());
		document.setSourceCreator(syncDocumentInput.getCreatorName());
		document.setStatusFlag(1);
		document.setPrintStatus(1);
		if (StringUtils.isNotBlank(syncDocumentInput.getSubject())) {
			document.setCourseID(Integer.parseInt(syncDocumentInput.getSubject()));
		}
		document.setExamNo(syncDocumentInput.getExamNo());
		document.setExamName(syncDocumentInput.getExamName());
		return document;
	}

	/**
	 * 同步文档入参校验
	 * 
	 * @param syncDocumentInput
	 * @return
	 * @throws Exception
	 */
	private SyncDocumentOutput check(SyncDocumentInput syncDocumentInput) throws Exception {
		User user = userDao.getByUserCode(syncDocumentInput.getUserCode());
		if (null == user) {
			log.error(MessageFormat.format("用户不存在:sourceCode={0},documentTypeID={1}", syncDocumentInput.getDocumentId(),
					syncDocumentInput.getDocumentType()));
			return new SyncDocumentOutput(CommonConst.RESULT_N, false, null, "用户不存在");
		}
		if (documentDao.checkExistByUCodeAndSCode(syncDocumentInput.getDocumentId(),
				syncDocumentInput.getDocumentType())) {
			log.error(MessageFormat.format("文档已存在:sourceCode={0},documentTypeID={1}", syncDocumentInput.getDocumentId(),
					syncDocumentInput.getDocumentType()));
			return new SyncDocumentOutput(CommonConst.RESULT_N, false, null, "文档已存在");
		}
		return null;
	}

	@Override
	public int updatePrintRecode(DocumentPrintRecord documentPrintRecord) {
		return documentDao.updatePrintRecode(documentPrintRecord);
	}

	@Override
	public long insertPrintRecode(DocumentPrintRecord documentPrintRecord) {
		return documentDao.insertPrintRecode(documentPrintRecord);
	}

	@Override
	public ResultBase updateByReportInfo(UpdateDocumentInput updateDocumentInput) throws Exception {
		Document document = null;
		String documentIDStr = CryptogramHelper.decryptThreeDESECB(updateDocumentInput.getDocumentID(),
				CommonConst.DESKEY);
		if (StringUtils.isBlank(documentIDStr)) {
			return new ResultBase(2, "documentID入参解密失败", false);
		}
		long documentID = Long.parseLong(documentIDStr);
		if (documentID > 0) {
			document = get(documentID);
		}
		if (null == document) {
			return new ResultBase(2, "根据documentID获取document失败", false);
		}
		document.setPrintUrl(updateDocumentInput.getPrnUrl());
		if (updateDocumentInput.getStatusFlag() == 1) {
			document.setStatusFlag(2);
			document.setPrintStatus(1);
		} else {
			document.setStatusFlag(99);
		}
		int result = this.update(document);

		if (result <= 0) {
			return new ResultBase(2, "更新文档表时异常", false);
		}
		return new ResultBase(1, "文档转换状态更新成功", true);
	}
}