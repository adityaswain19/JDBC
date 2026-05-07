package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Inventory;
import tech.csm.entity.Orders;

public interface InventoryDao {

	List<Inventory> getAllProduct();

	Inventory getOrderById(int id);

}
