package com.fda.DAO;

import java.util.List;

import com.fda.pojo.orders;

public interface ordersDAO {
    void addOrder(orders orders);
    orders getOrderById(int orderId);
    List<orders> getAllOrders();
    boolean updateOrder(orders orders);
    void deleteOrder(int orderId);
}
