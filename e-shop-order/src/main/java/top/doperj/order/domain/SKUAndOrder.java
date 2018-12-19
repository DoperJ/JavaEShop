package top.doperj.order.domain;

public class SKUAndOrder {
    private Integer skuAndOrderId;

    private Integer skuId;

    private Integer orderId;

    private Integer skuAmount;

    public Integer getSkuAndOrderId() {
        return skuAndOrderId;
    }

    public void setSkuAndOrderId(Integer skuAndOrderId) {
        this.skuAndOrderId = skuAndOrderId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSkuAmount() {
        return skuAmount;
    }

    public void setSkuAmount(Integer skuAmount) {
        this.skuAmount = skuAmount;
    }
}