package com.food.model;
import java.util.List;


public class OrderDetails {
	private Order order;
    private List<CartItem> items;

    public OrderDetails() {
    }

    public OrderDetails(Order order, List<CartItem> items) {
        this.order = order;
        this.items = items;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

}
