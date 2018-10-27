package com.ry.cds.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.bo.Document;
import com.ry.cds.user.bo.DocumentPrintRecord;
import com.ry.cds.user.mapper.DocumentMapper;
import com.ry.cds.user.service.CouchBaseFactory;

@Repository
public class DocumentDao implements IDocumentDao {
	@Autowired
	DocumentMapper documentMapper;

	@Override
	public Document get(long documentID) throws Exception {
		Document document = new Document();
		document.setDocumentID(documentID);
		Document rtnDocument = CouchBaseFactory.get(Document.class, document.key());
		if (null == rtnDocument) {
			rtnDocument = documentMapper.get(documentID);
			if (null != rtnDocument) {
				CouchBaseFactory.update(rtnDocument);
			}
		}
		return rtnDocument;
	}

	@Override
	public long insert(Document document) throws Exception {
		int result = documentMapper.insert(document);
		long documentID = 0;
		if (result > 0) {
			documentID = document.getDocumentID();// 该对象的自增ID
			CouchBaseFactory.update(document);
		}
		return documentID;
	}
	
	@Override
	public int update(Document document) throws Exception {
		int result = documentMapper.update(document);
		if (result > 0) {
			CouchBaseFactory.update(document);
		}
		return result;
	}

	@Override
	public boolean checkExistByUCodeAndSCode(String sourceCode, int documentTypeID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sourceCode", sourceCode);
		params.put("documentTypeID", documentTypeID);
		int result = documentMapper.checkExistByUCodeAndSCode(params);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Document> getByUserID(long userID) {
		return documentMapper.getByUserID(userID);
	}

	@Override
	public long insertPrintRecode(DocumentPrintRecord documentPrintRecord) {
		int result = documentMapper.insertPrintRecord(documentPrintRecord);
		if (result > 0) {
			return documentPrintRecord.getPrintRecordID();
		}
		return result;
	}


	@Override
	public int updatePrintRecode(DocumentPrintRecord documentPrintRecord) {
		return documentMapper.updatePrintRecord(documentPrintRecord);
	}

}