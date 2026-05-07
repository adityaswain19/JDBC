package tech.csm.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tech.csm.dao.AdmissionDaoImpl;
import tech.csm.dao.CollegeDaoImpl;
import tech.csm.entity.Admission;
import tech.csm.entity.College;
import tech.csm.service.AdmissionService;
import tech.csm.service.AdmissionServiceImpl;
import tech.csm.service.CollegeService;
import tech.csm.service.CollegeServiceImpl;

public class Runner {
	static Scanner sc = new Scanner(System.in);
	static Scanner scs = new Scanner(System.in);
	
	//static CollegeService collegeService=new CollegeServiceImpl(new CollegeDaoImpl());

	public static void main(String[] args) {
		int choice;
		CollegeService collegeService=new CollegeServiceImpl(new CollegeDaoImpl());
		AdmissionService admissionService=new AdmissionServiceImpl(new AdmissionDaoImpl());
		
		do {
			System.out.println(
					"\n1.Add new college\n2.Remove college By Id" + "\n3.Update college\n4.Search college by Id\n"
							+ "5.Show All colleges\n6.Take Admission\n7.Exit\nEnter your choice [1..6] :");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				College col=new College();
				System.out.println("Enter college name");
				col.setCollegeName(scs.nextLine());
				System.out.println("Enter the address");
				col.setAddress(scs.nextLine());
				System.out.println("Enter no of seats");
				col.setNoOfSeats(sc.nextInt());
				System.out.println(collegeService.addCollege(col));
				
				break;
			case 2:
				System.out.println("Enter the college Id to remove:");
				Integer collegeId=sc.nextInt();
				System.out.println(collegeService.removeCollege(collegeId));
				
				
				break;
			case 3:
				
				break;
			case 4:
				
				System.out.println("Enter the college Id:");
				collegeId=sc.nextInt();
				College co=collegeService.getCollegeById(collegeId);
				if(co!=null)
					System.out.println(co);
				else
					System.out.println("college not found!!!");
				
				
				break;
			case 5:
				List<College> collegeList=collegeService.getAllCollege();
				for(College c:collegeList)
					System.out.println(c);
				
				
				break;
			case 6:
				List<Admission> admissionList=new ArrayList<>();
				char ch='y';
				
				do {
				Admission admission=new Admission();				
				System.out.println("Enter candidate name");
				admission.setCandidateName(scs.nextLine());
				System.out.println("Enter college id from below list");
				collegeList=collegeService.getAllCollege();
				for(College c:collegeList)
					System.out.println(c);
				
				College cl=collegeService.getCollegeById(sc.nextInt());
				if(cl.getNoOfSeats()<=0) {
					System.out.println("insufficeint no of seats, better to chose other college");
					continue;
				}
					
				admission.setCollege(cl);
				
				admissionList.add(admission);
				
				System.out.println("Would you like to add more admission [y/n]:");
				ch=scs.nextLine().charAt(0);
				
				}while(ch=='y');
				
				
				System.out.println(admissionService.newAdmission(admissionList));
				
				
				break;
			case 7:
				break;
			default:
				System.out.println("invalid option!!!!");

			}
		} while (choice != 7);
	}

}
