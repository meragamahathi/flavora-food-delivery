package com.food.model;

import java.sql.Timestamp;

public class Order {
	 private int orderId;
	 private int userId;
	 private int restaurantId;
	 private Timestamp orderDate;
	 private double totalAmount;
	 private String status;
	 private String paymentMethod;
	 private String paymentId;
	 private String paymentStatus;
	 private int deliveryAgentId;
	 private String deliveryStatus;
	 
	 public Order() {
		 
	 }

	 public Order(int orderId, int userId, int restaurantId, Timestamp orderDate, double totalAmount, String status,
			String paymentMethod,String paymentId,String paymentStatus,int deliveryAgentId,String deliveryStatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.paymentId=paymentId;
		this.paymentStatus=paymentStatus;
		this.deliveryAgentId=deliveryAgentId;
		this.deliveryStatus=deliveryStatus;
	 }

	 public Order(int userId, int restaurantId, double totalAmount, String status, String paymentMethod,String paymentId,String paymentStatus) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.paymentId=paymentId;
		this.paymentStatus=paymentStatus;
	}

	 public int getOrderId() {
		 return orderId;
	 }

	 public void setOrderId(int orderId) {
		 this.orderId = orderId;
	 }

	 public int getUserId() {
		 return userId;
	 }

	 public void setUserId(int userId) {
		 this.userId = userId;
	 }

	 public int getRestaurantId() {
		 return restaurantId;
	 }

	 public void setRestaurantId(int restaurantId) {
		 this.restaurantId = restaurantId;
	 }

	 public Timestamp getOrderDate() {
		 return orderDate;
	 }

	 public void setOrderDate(Timestamp orderDate) {
		 this.orderDate = orderDate;
	 }

	 public double getTotalAmount() {
		 return totalAmount;
	 }

	 public void setTotalAmount(double totalAmount) {
		 this.totalAmount = totalAmount;
	 }

	 public String getStatus() {
		 return status;
	 }

	 public void setStatus(String status) {
		 this.status = status;
	 }

	 public String getPaymentMethod() {
		 return paymentMethod;
	 }

	 public void setPaymentMethod(String paymentMethod) {
		 this.paymentMethod = paymentMethod;
	 }
	 
	 public String getPaymentId() {
		    return paymentId;
	 }

	 public void setPaymentId(String paymentId)
	 {
		    this.paymentId = paymentId;
	 }
	 
	 public String getPaymentStatus() {
		   return paymentStatus;
	 }

	 public void setPaymentStatus(String paymentStatus) {
		   this.paymentStatus = paymentStatus;
	 }
	 

	 public int getDeliveryAgentId() {
		return deliveryAgentId;
	}

	 public void setDeliveryAgentId(int deliveryAgentId) {
		 this.deliveryAgentId = deliveryAgentId;
	 }

	 public String getDeliveryStatus() {
		 return deliveryStatus;
	 }

	 public void setDeliveryStatus(String deliveryStatus) {
		 this.deliveryStatus = deliveryStatus;
	 }

	 @Override
	 public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMethod=" + paymentMethod
				+ ", paymentId=" + paymentId + ", paymentStatus=" + paymentStatus + ", deliveryAgentId="
				+ deliveryAgentId + ", deliveryStatus=" + deliveryStatus + "]";
	 }

	 
	 

}
