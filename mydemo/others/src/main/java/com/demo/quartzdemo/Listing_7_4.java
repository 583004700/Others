package com.demo.quartzdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class Listing_7_4 {
    static Log logger = LogFactory.getLog(Listing_7_4.class);

    public static void main(String[] args) {
        Listing_7_4 example = new Listing_7_4();

        try {
            example.startScheduler();
        } catch (SchedulerException ex) {
            logger.error(ex);
        }
    }

    public void startScheduler() throws SchedulerException {

        Scheduler scheduler = null;

        try {
            // Create the scheduler and JobDetail
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail jobDetail =
                    new JobDetail("ScanDirectory1o",
                            Scheduler.DEFAULT_GROUP,
                            ScanDirectoryJob.class);
            // Configure the directory to scan
            jobDetail.getJobDataMap().put("SCAN_DIR",
                    "d:\\quartz-book\\input");

              /*
               * Set up a trigger to start firing now, with no end
               * date/time, repeat forever and have
               * 10 secs (10000 ms) between each firing.
               */
            Trigger trigger =
                    TriggerUtils.makeSecondlyTrigger(10);

            trigger.setName("SimpleTrigger10");
            trigger.setStartTime(new Date());

            // Create the job listener
            JobListener jobListener =
                    new SimpleJobListener();

            // Register Listener as a nonglobal listener
            scheduler.addJobListener(jobListener);

            // Listener set on JobDetail before scheduleJob()
            jobDetail.addJobListener(jobListener.getName());

            // Register the JobDetail and Trigger
            scheduler.scheduleJob(jobDetail, trigger);

            // Start the scheduler
            scheduler.start();
            logger.info("Scheduler started at " + new Date());

        } catch (SchedulerException ex) {
            logger.error(ex);
        }
    }
}
