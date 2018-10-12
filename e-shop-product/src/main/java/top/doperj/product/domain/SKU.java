package top.doperj.product.domain;

public class SKU {
    private Integer skuId;

    private Integer productId;

    private String photoUrl;

    private Float originalPrice;

    private Float salePrice;

    private Integer stockQuantity;

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public Float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "SKU{" +
                "skuId=" + skuId +
                ", productId=" + productId +
                ", photoUrl='" + photoUrl + '\'' +
                ", originalPrice=" + originalPrice +
                ", salePrice=" + salePrice +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}