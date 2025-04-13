package com.fda.DAO;

import java.util.List;

import com.fda.pojo.restaurant;
import com.fda.pojo.user;

public interface restaurantDAO {
	void insertRestaurant(restaurant restaurant);
	List<restaurant> fetchAll();
	restaurant fetchRestaurant(int id);
	void deleteRestaurant(int id);
}