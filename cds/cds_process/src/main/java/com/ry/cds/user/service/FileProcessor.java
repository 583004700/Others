package com.ry.cds.user.service;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.cds.FileProcessorController;
import com.ry.cds.print.service.IPrintBulkProcessService;
import com.ry.cds.springbootframe.config.CommonConfig;

@Component
public class FileProcessor extends AbstractFileProcessor {
	private static Logger log = LoggerFactory.getLogger(FileProcessorController.class);
	@Autowired
	CommonConfig commonConfig;
	@Autowired
	IUserBulkProcessService userBulkProcessService;

	@Autowired
	IPrintBulkProcessService printBulkProcessService;
	@Autowired
	DataSource dataSource;

	@Override
	public String getPath() {
		return commonConfig.getFilePath().get("generalFileDataPath").toString();
	}

	@Override
	public int process(String fileUrl) {
		int count = 0;
		setBusy(true);
		try {
			int beginPos = fileUrl.indexOf("[");
			int endPos = fileUrl.indexOf("]");
			if (beginPos > 0 && endPos > beginPos) {
				String[] dataInfo = fileUrl.substring(beginPos + 1, endPos).split("-");
				if (Integer.parseInt(dataInfo[1]) == 2) {
					count = printBulkProcessService.bulkInsert(fileUrl, dataInfo[2]);
				} else {
					count = userBulkProcessService.bulkInsert(fileUrl, dataInfo[2]);
				}
			}
		} catch (Exception e) {
			setBusy(false);
			count = -1;
			log.error("文件导入数据库异常：", e);
		} finally {
			setBusy(false);
		}
		return count;
	}
}
