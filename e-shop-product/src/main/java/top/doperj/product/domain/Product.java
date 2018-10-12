package top.doperj.product.domain;

import java.util.Date;

public class Product {
    private Integer productId;

    private String productName;

    private String abbreviation;

    private String details;

    private Integer clickedTimes;

    private Integer saleQuantity;

    private String photoUrl;

    private Boolean isHot;

    private Boolean isNew;

    private Date onSaleDate;

    private Integer categoryId;

    private Integer brandId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation == null ? null : abbreviation.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public Integer getClickedTimes() {
        return clickedTimes;
    }

    public void setClickedTimes(Integer clickedTimes) {
        this.clickedTimes = clickedTimes;
    }

    public Integer getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Integer saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Date getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", details='" + details + '\'' +
                ", clickedTimes=" + clickedTimes +
                ", saleQuantity=" + saleQuantity +
                ", photoUrl='" + photoUrl + '\'' +
                ", isHot=" + isHot +
                ", isNew=" + isNew +
                ", onSaleDate=" + onSaleDate +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                '}';
    }
}