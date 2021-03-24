package com.io.t11.reportingservice.service;

import com.io.t11.reportingservice.model.Index;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class IndexService {

    public Index index() {
        Index index = new Index(true, "Reporting Service", LocalDate.now());
        System.out.println("Hit index at: " + index.getDate());
        return index;
    }
}
