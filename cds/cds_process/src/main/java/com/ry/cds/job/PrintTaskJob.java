package com.ry.cds.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ry.cds.print.service.IPrintTaskService;

@DisallowConcurrentExecution
public class PrintTaskJob implements BaseJob {
	private static final Logger log = LoggerFactory.getLogger(PrintTaskJob.class);

	@Autowired
	IPrintTaskService printTaskService;

	public PrintTaskJob() {
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		printTaskService.runPrintTaskMigrateTask();
		log.info("打印数据迁移至历史数据完成");
	}
}