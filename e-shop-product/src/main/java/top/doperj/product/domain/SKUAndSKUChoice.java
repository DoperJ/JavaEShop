package top.doperj.product.domain;

public class SKUAndSKUChoice {
    private Integer id;

    private Integer skuChoiceId;

    private Integer skuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSkuChoiceId() {
        return skuChoiceId;
    }

    public void setSkuChoiceId(Integer skuChoiceId) {
        this.skuChoiceId = skuChoiceId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    @Override
    public String toString() {
        return "SKUAndSKUChoice{" +
                "id=" + id +
                ", skuChoiceId=" + skuChoiceId +
                ", skuId=" + skuId +
                '}';
    }
}