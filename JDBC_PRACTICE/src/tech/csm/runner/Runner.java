package tech.csm.runner;
import java.util.List;
import java.util.Scanner;

import tech.csm.dao.InventoryDaoImpl;
import tech.csm.dao.OrderDaoImpl;
import tech.csm.entity.Inventory;
import tech.csm.entity.Orders;
import tech.csm.service.InventoryImpl;
import tech.csm.service.InventoryService;
import tech.csm.service.OrderService;
import tech.csm.service.OrderServiceImpl;


public class Runner {

	static Scanner sc=new Scanner(System.in);
	static Scanner scs=new Scanner(System.in);
	
	public static void main(String[] args) {

		InventoryService inventoryService=new InventoryImpl(new InventoryDaoImpl());
		OrderService orderService=new OrderServiceImpl(new OrderDaoImpl());

		int choice;
		do {
			System.out.println("1.Create orders\n2.Modify orders\n3.Cancel order\n4.Show all orders\n"
					+ "5.Exit\nEnter your choice[1..5]");
			
		
			choice=sc.nextInt();
		
			switch(choice) {
			
			case 1:
				
				List<Inventory> inventoryList=inventoryService.getAllProduct();
		
				for(Inventory inv:inventoryList) {
					System.out.println(inv);
				}
				System.out.println("Enter product id from the bellow list");
				int id=sc.nextInt();
				Inventory order=inventoryService.getOrderById(id);
				
				if(order ==null) {
					System.out.println("Invalid id...!!");
				}

				System.out.println("Enter order quantity ");
				int quantity=sc.nextInt();
				
				if(quantity>order.getStockQuantity()) {
					System.out.println("Quanity not available ");
				}
				else {
					Orders myOrder=new Orders();
					double total=quantity * order.getUnitPrice();
					total +=(total*(order.getGstPrice()/100));
					myOrder.setInventory(inventoryService.getOrderById(id));
					myOrder.setOrderQuantity(quantity);
					myOrder.setTotalBillAmount(total);
					System.out.println(orderService.addOrder(myOrder));
				}
				
				
				
				
				break;
			case 2:
				
				break;
			case 3:
				
				List<Orders> orderList=orderService.getAllOrders();
				for(Orders od:orderList) {
					System.out.println(od);
				}
				System.out.println("Enter order id to delete");
				id=sc.nextInt();
				
				Orders orders=orderService.getOrderById(id);
				
				
				
				break;
			case 4:
				
				List<Orders>orderListt=orderService.getAllOrders();
				for(Orders od:orderListt) {
					System.out.println(od);
				}
				break;
				
			case 5:
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		while(choice !=5);
	}

}
