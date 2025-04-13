package com.fda.pojo;

public class OrderItems {
	 private int orderItemsId;
	 private int ordersId;
	 private int menuId;
	 private int quantity;
	 private int itemTotal;
	public int getOrderItemsId() {
		return orderItemsId;
	}
	public void setOrderItemsId(int orderItemsId) {
		this.orderItemsId = orderItemsId;
	}
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}
	public OrderItems(int orderItemsId, int ordersId, int menuId, int quantity, int itemTotal) {
		super();
		this.orderItemsId = orderItemsId;
		this.ordersId = ordersId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}
	public OrderItems(int ordersId, int menuId, int quantity, int itemTotal) {
		super();
		this.ordersId = ordersId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}
	public OrderItems() {
		super();
	}
	@Override
	public String toString() {
		return "OrderItems [orderItemsId=" + orderItemsId + ", ordersId=" + ordersId + ", menuId=" + menuId
				+ ", quantity=" + quantity + ", itemTotal=" + itemTotal + "]";
	}
	 
	 
}
