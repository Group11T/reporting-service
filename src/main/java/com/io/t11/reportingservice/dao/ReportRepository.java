package com.io.t11.reportingservice.dao;

import com.io.t11.reportingservice.dto.ReportDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<ReportDto, Integer> {

    @Query("Select id, product, quantity, price, side, validationStatus, userId, publisher, publishedOn from ReportDto where publisher = :publisher")
    List<ReportDto> getAllPublishers(String publisher);
}
