package com.fda.DAO;

import java.util.List;

import com.fda.pojo.OrderHistory;

public interface OrderHistoryDAO {
    void addOrderHistory(OrderHistory orderHistory);
    OrderHistory getOrderHistoryById(int orderHistoryId);
    List<OrderHistory> getAllOrderHistories();
    boolean updateOrderHistory(OrderHistory orderHistory);
    void deleteOrderHistory(int orderHistoryId);
}
