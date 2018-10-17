package top.doperj.product.domain;

public class SKUAttribute {
    private Integer skuAttributeId;

    private String skuAttributeName;

    public Integer getSkuAttributeId() {
        return skuAttributeId;
    }

    public void setSkuAttributeId(Integer skuAttributeId) {
        this.skuAttributeId = skuAttributeId;
    }

    public String getSkuAttributeName() {
        return skuAttributeName;
    }

    public void setSkuAttributeName(String skuAttributeName) {
        this.skuAttributeName = skuAttributeName;
    }

    @Override
    public String toString() {
        return "SKUAttribute{" +
                "skuAttributeId=" + skuAttributeId +
                ", skuAttributeName=" + skuAttributeName +
                '}';
    }
}