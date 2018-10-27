package com.demo.quartzdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class Listing_4_3 {
    static Log logger = LogFactory.getLog(Listing_4_3.class);

    public static void main(String[] args) {
        Listing_4_3 example = new Listing_4_3();
        example.startScheduler();
    }

    public void startScheduler() {

        try {
            // Create a default instance of the Scheduler
            Scheduler scheduler =
                    StdSchedulerFactory.getDefaultScheduler();
            logger.info("Scheduler starting up...");
            scheduler.start();

        } catch (SchedulerException ex) {
            logger.error(ex);
        }
    }
}
