package com.io.t11.reportingservice.controller;

import com.io.t11.reportingservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportController {
    @Autowired
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    //todo:::endpoints to generate reports
}
