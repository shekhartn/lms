package com.photon.lms.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class LogHeartbeat {
    private static final Logger logger = LoggerFactory.getLogger(LogHeartbeat.class);

    @Scheduled(cron = "0 * * * * *") // Every 5 minutes
    public void logHeartbeat() {
        logger.info("Heartbeat log to trigger log file rollover.");
    }
}
