package com.demo.quartzdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.print.attribute.standard.PrinterInfo;
import java.util.Date;

public class Listing_4_9 {
    static Log logger = LogFactory.getLog(Listing_4_9.class);

    public static void main(String[] args) {
        Listing_4_9 example = new Listing_4_9();
        //example.startScheduler();
        example.manyTrigger();
    }

    public void startScheduler() {
        try {
            // Create and start the scheduler
            Scheduler scheduler =
                    StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            logger.info("Scheduler has been started");

            JobDetail jobDetail =
                    new JobDetail("ScanDirectory",
                            Scheduler.DEFAULT_GROUP,
                            ScanDirectoryJob.class);

            // Configure the directory to scan
            jobDetail.getJobDataMap().put("SCAN_DIR",
                    "d:\\quartz-book\\input");
               /*
                * Create a SimpleTrigger that starts immediately,
                * with a null end date/time, repeats forever and has
                * 1 minute (60000 ms) between each firing.
                */
            Trigger trigger =
                    new SimpleTrigger("myTrigger",
                            Scheduler.DEFAULT_GROUP, new Date(), null,
                            SimpleTrigger.REPEAT_INDEFINITELY,
                            60000L);

            scheduler.scheduleJob(jobDetail, trigger );

        } catch (SchedulerException ex) {
            logger.error(ex);
        }
    }

    public void manyTrigger(){
        try {
            // Create and start the scheduler
            Scheduler scheduler =
                    StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            logger.info("Scheduler has been started");

            JobDetail jobDetail =
                    new JobDetail("ScanDirectory",
                            Scheduler.DEFAULT_GROUP,
                            ScanDirectoryJob.class);
            // Configure the directory to scan
            jobDetail.getJobDataMap().put("SCAN_DIR",
                    "d:\\quartz-book\\input");

            // A trigger that fires every 5 seconds
            Trigger trigger1 =
                    TriggerUtils.makeSecondlyTrigger("trigger1",
                            5000, SimpleTrigger.REPEAT_INDEFINITELY);

            // A trigger that fires every 10 minutes
            Trigger trigger2 =
                    TriggerUtils.makeMinutelyTrigger("trigger2", 10,
                            SimpleTrigger.REPEAT_INDEFINITELY);

            // Schedule job with first trigger
            scheduler.scheduleJob(jobDetail, trigger1);

            // Schedule job with second trigger
            scheduler.scheduleJob(jobDetail, trigger2);

        } catch (SchedulerException ex) {
            logger.error(ex);
        }

    }

}
