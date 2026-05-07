package tech.csm.service;


import java.util.ArrayList;
import java.util.List;

import tech.csm.dao.InventoryDao;
import tech.csm.entity.Inventory;
import tech.csm.entity.Orders;
import tech.csm.util.DbUtil;

public class InventoryImpl implements InventoryService {
	

	private InventoryDao inventoryDao;
	

	public InventoryImpl(InventoryDao inventoryDao) {
		
		this.inventoryDao = inventoryDao;
	}


	@Override
	public List<Inventory> getAllProduct() {
		
		return inventoryDao.getAllProduct();
	}


	@Override
	public Inventory getOrderById(int id) {
		return inventoryDao.getOrderById(id);
	}
}
