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
    String skuName;
    float originalPrice;
    float salePrice;
    float discount;
    Integer stockQuantity;
    String photoUrl;
    String productName;
    //String finalCategory;


    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
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
                "skuName='" + skuName + '\'' +
                ", originalPrice=" + originalPrice +
                ", salePrice=" + salePrice +
                ", discount=" + discount +
                ", stockQuantity=" + stockQuantity +
                ", photoUrl='" + photoUrl + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
