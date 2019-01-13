package top.doperj.service.Entity;

import java.util.Map;

public class ViewOrderResponse {
    private Map<SKUView, Integer> items;
    private int addressId;
    private String first_name;
    private String last_name;
    private Float totalPrice;

    public Map<SKUView, Integer> getItems() {
        return items;
    }

    public void setItems(Map<SKUView, Integer> items) {
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

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ViewOrderResponse{" +
                "items=" + items +
                ", addressId=" + addressId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
