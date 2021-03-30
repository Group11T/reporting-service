package com.io.t11.reportingservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.io.t11.reportingservice.dao.ReportRepository;
import com.io.t11.reportingservice.dto.ReportDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportService {
    private static final Logger logger = LoggerFactory.getLogger((ReportService.class));

    private final ReportRepository reportRepository;
    //Todo:::business logic for reporting service

    public ReportService(ReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }

    public Integer convertAndSaveReport(String payload) throws JsonProcessingException{
        /*
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        ReportDto reportDto = objectMapper.readValue(payload, ReportDto.class);
        logger.info("Got report: {}", reportDto);

        reportRepository.save(reportDto);
        logger.info("Persisting: {}", reportDto);

        return reportDto.getId();
        */
        return 0;
    }

    public void convertToReport(String payload) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
//        ReportDto reportDto = objectMapper.readValue(payload, ReportDto.class);
    }
}
