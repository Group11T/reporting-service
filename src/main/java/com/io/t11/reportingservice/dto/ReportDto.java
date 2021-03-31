package com.io.t11.reportingservice.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class ReportDto {
    @Id
    private Integer id;

    private String product;
    private Integer quantity;
    private Double price;
    private String side;
    private String validationStatus;
    private Integer userId;
    private String publisher;
    private LocalDate publishedOn;

    public ReportDto(){}

    public ReportDto(Integer id, String product, Integer quantity, Double price, String side,
                     String validationStatus, Integer userId, String publisher, LocalDate publishedOn) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.validationStatus = validationStatus;
        this.userId = userId;
        this.publisher = publisher;
        this.publishedOn = publishedOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(String validationStatus) {
        this.validationStatus = validationStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(LocalDate publishedOn) {
        this.publishedOn = publishedOn;
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", side='" + side + '\'' +
                ", validationStatus='" + validationStatus + '\'' +
                ", userId=" + userId +
                ", publisher='" + publisher + '\'' +
                ", publishedOn=" + publishedOn +
                '}';
    }
}
