package com.io.t11.reportingservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class ReportServiceSubscriber implements MessageListener {
private static Logger logger = LoggerFactory.getLogger((ReportServiceSubscriber.class));
    @Override
    public void onMessage(Message message, byte[] pattern) {
        logger.info("Hit report service with: {}", message);
        System.out.println("Received message: " + message);
    }


}
