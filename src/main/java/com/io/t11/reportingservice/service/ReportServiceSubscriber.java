package com.io.t11.reportingservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.io.t11.reportingservice.dao.ReportRepository;
import com.io.t11.reportingservice.dto.ReportDto;
import com.io.t11.reportingservice.utility.CustomReportDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
public class ReportServiceSubscriber implements MessageListener {
private static Logger logger = LoggerFactory.getLogger((ReportServiceSubscriber.class));

    @Autowired
    private ReportRepository reportRepository;

    public ReportServiceSubscriber() {}

    public ReportServiceSubscriber(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        logger.info("Hit report service with: {}", message);
        try {
            System.out.println(convertToReport(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ReportDto convertToReport(Message payload) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomReportDeserializer", new Version(1, 0, 0, null, null, null));

        module.addDeserializer(ReportDto.class, new CustomReportDeserializer());
        objectMapper.registerModule(module);
        return objectMapper.readValue(payload.getBody(), ReportDto.class);
    }


}
