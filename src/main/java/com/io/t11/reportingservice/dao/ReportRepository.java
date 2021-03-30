package com.io.t11.reportingservice.dao;

import com.io.t11.reportingservice.dto.ReportDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository  extends JpaRepository<ReportDto, Long> {}
