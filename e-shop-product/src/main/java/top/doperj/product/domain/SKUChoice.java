package top.doperj.product.domain;

public class SKUChoice {
    private Integer skuChoiceId;

    private Integer skuAttributeId;

    private String skuChoiceName;

    public Integer getSkuChoiceId() {
        return skuChoiceId;
    }

    public void setSkuChoiceId(Integer skuChoiceId) {
        this.skuChoiceId = skuChoiceId;
    }

    public Integer getSkuAttributeId() {
        return skuAttributeId;
    }

    public void setSkuAttributeId(Integer skuAttributeId) {
        this.skuAttributeId = skuAttributeId;
    }

    public String getSkuChoiceName() {
        return skuChoiceName;
    }

    public void setSkuChoiceName(String skuChoiceName) {
        this.skuChoiceName = skuChoiceName == null ? null : skuChoiceName.trim();
    }

    @Override
    public String toString() {
        return "SKUChoice{" +
                "skuChoiceId=" + skuChoiceId +
                ", skuAttributeId=" + skuAttributeId +
                ", skuChoiceName='" + skuChoiceName + '\'' +
                '}';
    }
}