package com.ry.cds.user.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.amqp.bo.FileDataFormat;
import com.ry.cds.springbootframe.config.CommonConfig;
import com.ry.cds.utils.DateUtil;

@Service
public class GeneralFileDataService implements IGeneralFileDataService {
	private static Logger log = LoggerFactory.getLogger(GeneralFileDataService.class);
	private static Lock lock = new ReentrantLock();
	private String fileNameFomat = "[%s-%s-%s]_%s.txt";
	@Autowired
	CommonConfig commonConfig;

	@Override
	public void writeToFile(FileDataFormat fileDataFormat) {
		FileOutputStream fop = null;
		String path = commonConfig.getFilePath().get("generalFileDataPath").toString();
		String fileName = "";
		if (fileDataFormat.byHour) {
			fileName = String.format(fileNameFomat, fileDataFormat.getDataTypeId(),
					fileDataFormat.getConnectionTypeId(), fileDataFormat.getDataTableName(),
					DateUtil.getNextHourStrByFomat("MM-dd-yyyy-HH"));
		} else {
			fileName = String.format(fileNameFomat, fileDataFormat.getDataTypeId(),
					fileDataFormat.getConnectionTypeId(), fileDataFormat.getDataTableName(),
					DateUtil.getNextHourStrByFomat("MM-dd-yyyy"));
		}
		try {
			File file = new File(path + "/" + fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			List<String> dataLines = fileDataFormat.getDataLines();
			lock.lock();
			for (String dataLine : dataLines) {
				fop = new FileOutputStream(file, true);
				byte[] contentInBytes = dataLine.getBytes();
				fop.write(contentInBytes);
			}
			fop.flush();
			fop.close();
		} catch (IOException e) {
			log.error(String.format("写入%s文件异常：", fileName), e);
		} finally {
			try {
				if (fop != null) {
					fop.close();
					lock.unlock();
				}
			} catch (IOException e) {
				log.error(String.format("写入%s文件异常：", fileName), e);
			}
		}
	}

}
