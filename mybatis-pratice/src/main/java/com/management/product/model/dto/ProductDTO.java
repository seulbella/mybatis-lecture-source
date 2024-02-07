package com.management.product.model.dto;

public class ProductDTO {

    private String productCode;
    private String productName;
    private String originCost;
    private String releaseDate;
    private String discountRate;
    private String salesQuantity;
    private String stockQuantity;
    private String categoryCode;
    private String productionStatus;

    public ProductDTO() {
    }

    public ProductDTO(String productCode, String productName, String originCost, String releaseDate, String discountRate, String salesQuantity, String stockQuantity, String categoryCode, String productionStatus) {
        this.productCode = productCode;
        this.productName = productName;
        this.originCost = originCost;
        this.releaseDate = releaseDate;
        this.discountRate = discountRate;
        this.salesQuantity = salesQuantity;
        this.stockQuantity = stockQuantity;
        this.categoryCode = categoryCode;
        this.productionStatus = productionStatus;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOriginCost() {
        return originCost;
    }

    public void setOriginCost(String originCost) {
        this.originCost = originCost;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(String salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getProductionStatus() {
        return productionStatus;
    }

    public void setProductionStatus(String productionStatus) {
        this.productionStatus = productionStatus;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", originCost='" + originCost + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", discountRate='" + discountRate + '\'' +
                ", salesQuantity='" + salesQuantity + '\'' +
                ", stockQuantity='" + stockQuantity + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", productionStatus='" + productionStatus + '\'' +
                '}';
    }

}
