package tech.csm.service;

import java.util.Date;
import java.util.List;

import tech.csm.dao.OrderDao;
import tech.csm.entity.Orders;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	
	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public String addOrder(Orders myOrder) {

		myOrder.setOrderDate(new Date());
		return orderDao.addOrder(myOrder);
		
	}

	@Override
	public List<Orders> getAllOrders() {

		return orderDao.getAllOrders();
	}

	@Override
	public Orders getOrderById(int id) {
		return orderDao.getOrderById(id);
	}

}
