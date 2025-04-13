package com.fda.DAO;

import java.util.List;

import com.fda.pojo.OrderItems;

public interface OrderItemsDAO {
    void addOrderItem(OrderItems orderItem);
    OrderItems getOrderItemById(int orderItemsId);
    List<OrderItems> getAllOrderItems();
    boolean updateOrderItem(OrderItems orderItem);
    void deleteOrderItem(int orderItemsId);
}
