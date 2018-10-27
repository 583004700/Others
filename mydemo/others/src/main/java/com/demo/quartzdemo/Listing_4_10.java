package com.demo.quartzdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Listing_4_10 {
    static Log logger = LogFactory.getLog(Listing_4_10.class);

    public static void main(String[] args) {
        Listing_4_10 example = new Listing_4_10();
        example.startScheduler();
    }

    public void startScheduler() {
        try {
            // Create and start the scheduler
            Scheduler scheduler =
                    StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            scheduleJob(scheduler);

            logger.info("Scheduler starting up...");
            scheduler.start();

        } catch (SchedulerException ex) {
            logger.error(ex);
        }
    }

    private void scheduleJob(Scheduler scheduler) {
        try {
            // Create an instance of the Quartz AnnualCalendar
            AnnualCalendar cal = new AnnualCalendar();

            // exclude July 4th
            Calendar gCal = GregorianCalendar.getInstance();
            gCal.set(Calendar.MONTH, Calendar.APRIL);
            gCal.set(Calendar.DATE, 23);

            cal.setDayExcluded(gCal, true);

            // Add to scheduler, replace existing, update triggers
            scheduler.
                    addCalendar("bankHolidays", cal, true, true);

              /*
                       * Set up a trigger to start firing now, repeat forever
                       * and have (60000 ms) between each firing.
               */
            Trigger trigger =
                    TriggerUtils.makeImmediateTrigger("myTrigger",
                            -1,60);

            // Trigger will use Calendar to exclude firing times
            trigger.setCalendarName("bankHolidays");

            JobDetail jobDetail =
                    new JobDetail("ScanDirectory",
                            Scheduler.DEFAULT_GROUP,
                            ScanDirectoryJob.class);
            // Configure the directory to scan
            jobDetail.getJobDataMap().put("SCAN_DIR",
                    "d:\\quartz-book\\input");


            // Associate the trigger with the job in the scheduler
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException ex) {
            logger.error(ex);
        }
    }

}
