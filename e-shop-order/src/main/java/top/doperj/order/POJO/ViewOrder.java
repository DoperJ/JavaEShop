package top.doperj.order.POJO;

import top.doperj.order.domain.Order;

import java.util.List;
import java.util.Map;

public class ViewOrder {
    private Map<Integer, Integer> items;
    private int addressId;

    public Map<Integer, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Integer> items) {
        this.items = items;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "ViewOrder{" +
                "items=" + items +
                ", addressId=" + addressId +
                '}';
    }
}
