package top.doperj.user.pojo;

import java.io.Serializable;

public class CartItem implements Serializable {
    int skuId;
    int skuNum;

    public CartItem() {
    }

    public CartItem(int skuId, int skuNum) {
        this.skuId = skuId;
        this.skuNum = skuNum;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(int skuNum) {
        this.skuNum = skuNum;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "skuId=" + skuId +
                ", skuNum=" + skuNum +
                '}';
    }
}
