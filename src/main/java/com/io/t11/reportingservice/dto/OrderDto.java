package com.io.t11.reportingservice.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderDto {
    private String product;
    private int quantity;
    private double price;
    private String side;
    private String uniqueId;
    private String validationStatus;
    private Long userId;
    private Long cumulativeQuantity;
    private String exchangeTradedOn;
    private Long id;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(String validationStatus) {
        this.validationStatus = validationStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCumulativeQuantity() {
        return cumulativeQuantity;
    }

    public void setCumulativeQuantity(Long cumulativeQuantity) {
        this.cumulativeQuantity = cumulativeQuantity;
    }

    public String getExchangeTradedOn() {
        return exchangeTradedOn;
    }

    public void setExchangeTradedOn(String exchangeTradedOn) {
        this.exchangeTradedOn = exchangeTradedOn;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", side='" + side + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", validationStatus='" + validationStatus + '\'' +
                ", userId='" + userId + '\'' +
                ", cumulativeQuantity=" + cumulativeQuantity +
                ", exchangeTradedOn='" + exchangeTradedOn + '\'' +
                ", id=" + id +
                '}';
    }
}