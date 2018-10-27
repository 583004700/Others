package com.ry.cds;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aliyun.oss.model.OSSObject;
import com.ry.cds.amqp.bo.FileDataFormat;
import com.ry.cds.amqp.bo.UserAccountChange;
import com.ry.cds.print.bo.PrinterReportRecord;
import com.ry.cds.user.bo.SystemConfig;
import com.ry.cds.user.bo.User;
import com.ry.cds.user.bo.UserAccount;
import com.ry.cds.user.service.CouchBaseFactory;
import com.ry.cds.user.service.ISystemConfigService;
import com.ry.cds.user.service.IUserService;
import com.ry.cds.utils.DateUtil;
import com.ry.cds.utils.FileOperator;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RabbitTests {
	@Autowired
	private MQSender mqSender;
	@Autowired
	ISystemConfigService systemConfigService;
	private String uuidfileName;
	@Autowired
	IUserService userService;
	@Autowired
	ConnectionFactory connectionFactory;

	// @Test
	public void MQTest() throws Exception {
		PrinterReportRecord printerReportRecord = new PrinterReportRecord();
		printerReportRecord.setReportDateTime("2018-03-15 16:54:55");
		printerReportRecord.setPrinterID(2);
		printerReportRecord.setPrinterStatus(1);
		printerReportRecord.setStatusCode("-1");
		printerReportRecord.setPrintedTotalPageCount(0);
		printerReportRecord.setErrorPaperCount(0);
		printerReportRecord.setCarryPaperCount(0);
		printerReportRecord.setPaperBoxRemain(1);
		printerReportRecord.setTonerRemain(0);
		printerReportRecord.setWasteRemain(0);
		printerReportRecord.setDrumRemain(0);
		printerReportRecord.setInkboxPrintedCount(0);
		printerReportRecord.setInkboxReaminPrintCount(0);
		printerReportRecord.setInkboxSN("xxsn");
		printerReportRecord.setInkboxStatus(1);
		printerReportRecord.setIp("10.0.3.10");
		printerReportRecord.setWifiSsid("wwww");
		printerReportRecord.setWifiPassword("yyyy");
		printerReportRecord.setLng("120.32021545");
		printerReportRecord.setLat("120.32021545");
		List<String> dataLines = new ArrayList<String>();
		dataLines.add(printerReportRecord.toString());
		mqSender.send(new FileDataFormat(dataLines, true, 1, 2, "printerreportrecord",
				DateUtil.getDateString("yyyy-MM-dd HH:mm:ss")));
	}

	/**
	 * Couchbase、protobuf、gzip
	 * 
	 * @throws Exception
	 */
	// @Test
	public void couchbaseTest() throws Exception {
		User user = new User();
		user.setUserID(1L);
		user.setUserCode("NO1025485454");
		CouchBaseFactory.add(user, 5);
		System.out.println(CouchBaseFactory.get(User.class, user.key()));
		System.out.println(CouchBaseFactory.remove(user.couchbaseSection(), user.key()));
	}

	// @Test
	public void ossUploadFileTest() throws Exception {
		SystemConfig systemConfig = systemConfigService.systemConfigs();
		FileOperator fileOperator = new FileOperator(systemConfig);
		InputStream is = new FileInputStream(new File("D:/cdstest.docx"));
		this.uuidfileName = UUID.randomUUID().toString();
		fileOperator.UploadFile(uuidfileName + ".docx", is, "cdstest", false);
	}

	// @Test
	public void ossDownLoadFileTest() throws Exception {
		ossUploadFileTest();
		SystemConfig systemConfig = systemConfigService.systemConfigs();
		FileOperator fileOperator = new FileOperator(systemConfig);
		OSSObject ossobject = fileOperator.DownLoadFileObject(uuidfileName + ".docx", "cdstest", false);
		OutputStream os = new FileOutputStream(new File("D:/cdsoutputtest.docx"));
		byte[] b = new byte[1024];
		try {
			int len = -1;
			InputStream is = ossobject.getObjectContent();
			while ((len = (is.read(b))) != -1) {
				os.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			os.flush();
			os.close();
		}
	}

	// @Test
	public void ossDeleteFileTest() throws Exception {
		ossUploadFileTest();
		SystemConfig systemConfig = systemConfigService.systemConfigs();
		FileOperator fileOperator = new FileOperator(systemConfig);
		fileOperator.DeleteFile(uuidfileName + ".docx", "cdstest", false);
	}

	@Test
	public void test() throws Exception {
		UserAccountChange userAccountChange = new UserAccountChange();
		userAccountChange.setUserID(3);
		userAccountChange.setAccountTypeID(3);
		userAccountChange.setAmount(20000);
		userAccountChange.setPrice(20000);
		userAccountChange.setHandelType(3);
		mqSender.send(userAccountChange);
	}

	// @Test
	public void test2() throws Exception {
		UserAccount userAccount = new UserAccount();
		userAccount.setUserID(10000);
		userAccount.setAccountTypeID(1);
		userAccount = CouchBaseFactory.get(UserAccount.class, userAccount.key());
		System.out.println(userAccount.getAmount());
		System.out.println(userAccount.getUpdateDateTime());

	}

	// @Test
	public void test3() throws Exception {
		UserAccount userAccount = new UserAccount();
		userAccount.setUserID(10000);
		userAccount.setAccountNo("NO00001");
		userAccount.setAccountTypeID(1);
		userAccount.setAmount(20);
		userAccount.setCurrencyTypeID(1);
		userAccount.setFrezeeAmount(300000);
		userAccount.setStatusFlag(1);
		userAccount.setCreateDatetime(DateUtil.getDateString("yyyy-MM-dd HH:mm:ss"));
		userAccount.setUpdateDateTime(DateUtil.getDateString("yyyy-MM-dd HH:mm:ss"));
		CouchBaseFactory.updateCas(userAccount);
	}

}
