package top.doperj.product.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import top.doperj.product.domain.SKU;
import top.doperj.product.domain.SKUChoice;
import top.doperj.product.service.ProductService;
import top.doperj.product.service.SKUChoiceService;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

public class SKUView implements Serializable {
    Integer skuId;
    String skuName;
    String brandName;
    float originalPrice;
    float salePrice;
    Integer discount;
    Integer stockQuantity;
    String photoUrl;
    String productName;
    //String finalCategory;


    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "SKUView{" +
                "skuId=" + skuId +
                ", skuName='" + skuName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", originalPrice=" + originalPrice +
                ", salePrice=" + salePrice +
                ", discount=" + discount +
                ", stockQuantity=" + stockQuantity +
                ", photoUrl='" + photoUrl + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
