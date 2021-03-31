package com.io.t11.reportingservice.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portfolios")
public class PortfolioDto {

    private String ticker;
    private String stockQuantity;
    private String portfolioName;
    private Long userId;
    private Long id;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PortfolioDto{" +
                "ticker='" + ticker + '\'' +
                ", stockQuantity='" + stockQuantity + '\'' +
                ", portfolioName='" + portfolioName + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}