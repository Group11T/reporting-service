package com.io.t11.reportingservice.dao;

import com.io.t11.reportingservice.dto.PortfolioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<PortfolioDto, Long> {
    @Query("Select id, ticker, stockQuantity, portfolioName, userId from PortfolioDto where userId = :userId")
    List<PortfolioDto> getUserPortfolios(Long userId);
}
