package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Orders;

public interface OrderDao {

	String addOrder(Orders myOrder);

	List<Orders> getAllOrders();

	Orders getOrderById(int id);

}
