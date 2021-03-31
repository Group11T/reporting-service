package com.io.t11.reportingservice.service;

import com.io.t11.reportingservice.dao.ReportRepository;
import com.io.t11.reportingservice.dto.ReportDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//business logic
@Service
public class ReportService {

    @Autowired
    private final ReportRepository reportRepository;

    private static Logger logger = LoggerFactory.getLogger((ReportService.class));

    @Autowired
    public ReportService(ReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }

    // save report
    public ReportDto saveReport(ReportDto reportDto){
        logger.info("Saving request object: {}", reportDto);
        reportRepository.save(reportDto);
        return reportDto;
    }

    // get all orders
    public ArrayList<ReportDto> getAllOrders(){
        logger.info("Operation running.....");
        return (ArrayList<ReportDto>) reportRepository.findAll();
    }

    // get publisher orders
    public ArrayList<ReportDto> getPublisherOrders(String publisher) {
        logger.info("Operation running....");
        ReportDto reportDto = new ReportDto();
        reportDto.setPublisher(publisher);
        return (ArrayList<ReportDto>) reportRepository.getAllPublishers(reportDto.getPublisher());
    }
}
