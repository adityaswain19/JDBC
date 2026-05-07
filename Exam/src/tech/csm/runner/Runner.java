package tech.csm.runner;

import java.util.List;
import java.util.Scanner;

import tech.csm.service.*;
import tech.csm.dao.*;
import tech.csm.entity.Block;
import tech.csm.entity.State;
import tech.csm.util.DbUtil;

public class Runner { 
	
	static Scanner sc=new Scanner(System.in);
	static Scanner scs=new Scanner(System.in);

	

	public static void main(String[] args) {

		 StateService stateService=new StateServiceImpl (new StateDaoImpl());
		 BlockService blockService=new BlockServiceImpl (new BlockDaoImpl());

		System.out.println(DbUtil.getMyConnection());
		
		int choice;
		
				do {
					System.out.println("1.Update block\n2.Insert block\n3.Display block\n4.Delete block\n5.Exit\n6.Enter your choice[1..5]");
					choice=sc.nextInt();
					

		
		switch(choice) {
		case 1:
			List<Block> l1;
	        l1=blockService.getAllBlock();
			
			for(Block b:l1) {
				System.out.println(b);
			}
			
			System.out.println("Enter block id");
			String id=scs.nextLine();
			Block b=blockService.getBlockById(id);
//			System.out.println(b);
			System.out.println("Enter new BDO name");
			String newBDO=scs.nextLine();
			
            System.out.println("Do you want to  update ?");
			
			if(scs.nextLine().equalsIgnoreCase("yes")) {
				System.out.println(blockService.updateBlock(newBDO,id));

			}
			else {
				continue;
				
			}
												
			break;
		case 2:
       List<State> l=stateService.getAllState();
			
			for(State state:l) {
				System.out.println(state);
			}
			
			System.out.println("Enter state name from above list");
			String stateName=scs.nextLine();
			State state=stateService.getStateByName(stateName);
			System.out.println(state);
			
			Block block=new Block();
			
			System.out.println("Enter block id");
			block.setBlockId(scs.nextLine());
			System.out.println("Enter block name");
			block.setBlockName(scs.nextLine());
			System.out.println("Enter BDO name");
			block.setBDOName(scs.nextLine());
			
			block.setState(state);
			
			System.out.println("Do you want to insert ?");
			
			if(scs.nextLine().equalsIgnoreCase("yes")) {
				System.out.println(blockService.addBlock(block));

			}
			else {
				continue;
				
			}
			
			break;
		case 3:
			
			l1=blockService.displayBlock();
			for(Block b1:l1) {
				System.out.println("[ Block-Id="+b1.getBlockId()+",Block-Name="+b1.getBlockName()+",BDO-name= "+b1.getBDOName()+", State= "+b1.getState().getStateName()+"]");
			}
			
			
			
			break;
		case 4:
			l1=null;
	        l1=blockService.getAllBlock();
			
			for(Block b3:l1) {
				System.out.println(b3);
			}
			
			System.out.println("Enter block id");
			
			id=scs.nextLine();
			b=blockService.getBlockById(id);
			
			if(b==null) {
				System.out.println("Invalid block id");
			}
			else {
				
				System.out.println("[Block-Name="+b.getBlockName()+",BDO-name= "+b.getBDOName()+", State= "+b.getState().getStateName()+"]");

				System.out.println("Do u want to delete ?");
				
				if(scs.nextLine().equalsIgnoreCase("yes")) {
					System.out.println(blockService.deleteBlock(id));

				}
				
				else {
					continue;
					
				}

			}

			break;
			
		case 5:
			
			DbUtil.closeMyConnection();

			break;
		
		default:
			System.out.println("Invalid choice");
		}
	}while(choice !=5);
	}

}
