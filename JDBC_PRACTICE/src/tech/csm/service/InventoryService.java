package tech.csm.service;

import java.util.List;

import tech.csm.entity.Inventory;
import tech.csm.entity.Orders;

public interface InventoryService {

	List<Inventory> getAllProduct();

	Inventory getOrderById(int id);

}
