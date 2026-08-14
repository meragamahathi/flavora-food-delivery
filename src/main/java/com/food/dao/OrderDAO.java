package com.food.dao;

import java.util.List;

import com.food.model.Order;

public interface OrderDAO {
	int addOrder(Order order);

    Order getOrder(int orderId);

    void updateOrderStatus(int orderId, String status);
    
    void deleteOrder(int orderId);

    List<Order> getAllOrders();
    
    public int getOrderCount();
    
    List<Order> getOrdersByUserId(int userId);
    
    public void updateDeliveryStatus(int orderId, String status);

}
