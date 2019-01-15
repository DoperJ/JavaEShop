package top.doperj.common.Entity;

public class OrderSKUView {
    Integer skuId;
    String skuName;
    String brandName;
    float originalPrice;
    float salePrice;
    Integer discount;
    Integer stockQuantity;
    String photoUrl;
    String productName;
    Integer skuNum;

    public OrderSKUView() {
    }

    public OrderSKUView(SKUView skuView, int skuNum) {
        this.skuId = skuView.skuId;
        this.skuName = skuView.skuName;
        this.brandName = skuView.brandName;
        this.originalPrice = skuView.originalPrice;
        this.salePrice = skuView.salePrice;
        this.discount = skuView.discount;
        this.stockQuantity = skuView.stockQuantity;
        this.photoUrl = skuView.photoUrl;
        this.productName = skuView.productName;
        this.skuNum = skuNum;
    }

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

    public Integer getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    @Override
    public String toString() {
        return "OrderSKUView{" +
                "skuId=" + skuId +
                ", skuName='" + skuName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", originalPrice=" + originalPrice +
                ", salePrice=" + salePrice +
                ", discount=" + discount +
                ", stockQuantity=" + stockQuantity +
                ", photoUrl='" + photoUrl + '\'' +
                ", productName='" + productName + '\'' +
                ", skuNum=" + skuNum +
                '}';
    }
}
