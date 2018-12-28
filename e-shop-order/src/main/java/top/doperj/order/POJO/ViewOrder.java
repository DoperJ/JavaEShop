package top.doperj.order.POJO;

import top.doperj.order.domain.Order;

import java.util.List;
import java.util.Map;

public class ViewOrder {
    private Map<Integer, Integer> items;
    private int addressId;
    private String first_name;
    private String last_name;

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "ViewOrder{" +
                "items=" + items +
                ", addressId=" + addressId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
