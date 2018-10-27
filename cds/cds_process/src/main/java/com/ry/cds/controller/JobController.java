package com.ry.cds.controller;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ry.cds.job.BaseJob;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/job")
@Api("JobController相关api")
public class JobController {
	private static final Logger log = LoggerFactory.getLogger(JobController.class);

	@ApiOperation("添加用户")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "jobClassName", dataType = "String", required = true, value = "任务名称", defaultValue = ""),
			@ApiImplicitParam(paramType = "query", name = "jobGroupName", dataType = "String", required = true, value = "任务分组", defaultValue = ""),
			@ApiImplicitParam(paramType = "query", name = "cronExpression", dataType = "String", required = true, value = "表达式", defaultValue = "") })
	@RequestMapping(value = "/addJob", method = RequestMethod.POST)
	public void addjob(@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName,
			@RequestParam(value = "cronExpression") String cronExpression) throws Exception {
		addJob(jobClassName, jobGroupName, cronExpression);
	}

	public static void addJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception {

		// 通过SchedulerFactory获取一个调度器实例
		SchedulerFactory sf = new StdSchedulerFactory();

		Scheduler sched = sf.getScheduler();

		// 启动调度器
		sched.start();

		// 构建job信息
		JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass())
				.withIdentity(jobClassName, jobGroupName).build();

		// 表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

		// 按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
				.withSchedule(scheduleBuilder).build();

		try {
			sched.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			log.error("创建定时任务失败" + e);
			throw new Exception("创建定时任务失败");
		}
	}

	public static BaseJob getClass(String classname) throws Exception {
		Class<?> class1 = Class.forName(classname);
		return (BaseJob) class1.newInstance();
	}

}