package com.demo.quartzdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class Listing_7_3 {
    static Log logger = LogFactory.getLog(Listing_7_3.class);

    public static void main(String[] args) {
        Listing_7_3 example = new Listing_7_3();

        try {
            example.startScheduler();
        } catch (SchedulerException ex) {
            logger.error(ex);
        }
    }

    public void startScheduler() throws SchedulerException {

        // Create an instance of the factory
        Scheduler scheduler = null;

        // Create the scheduler and JobDetail
        scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail =
                new JobDetail("ScanDirectory",
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
        Trigger trigger = TriggerUtils.makeSecondlyTrigger(10);
        trigger.setName("SimpleTrigger");
        trigger.setStartTime(new Date());

        // Register the JobDetail and Trigger
        scheduler.scheduleJob(jobDetail, trigger);

        // Create and register the global job listener
        JobListener jobListener =
                new SimpleJobListener();

        scheduler.addGlobalJobListener(jobListener);
        // Start the scheduler
        scheduler.start();
        logger.info("Scheduler was started at " + new Date());
    }
}
