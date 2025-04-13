package com.fda.pojo;

public class OrderHistory {
    private int orderHistoryId;
    private int orderId;
    private int userId;
    private int restaurantId;
    private int total;
    private String status;
	public int getOrderHistoryId() {
		return orderHistoryId;
	}
	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrderHistory(int orderHistoryId, int orderId, int userId, int restaurantId, int total, String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.total = total;
		this.status = status;
	}
	public OrderHistory(int orderId, int userId, int restaurantId, int total, String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.total = total;
		this.status = status;
	}
	public OrderHistory() {
		super();
	}
	@Override
	public String toString() {
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", orderId=" + orderId + ", userId=" + userId
				+ ", restaurantId=" + restaurantId + ", total=" + total + ", status=" + status + "]";
	}
    
    
}
