package tech.csm.runner;

import java.util.List;
import java.util.Scanner;

import tech.csm.entity.Projects;
import tech.csm.entity.Tasks;
import tech.csm.service.ProjectsService;
import tech.csm.service.ProjectsServiceImpl;
import tech.csm.service.TasksService;
import tech.csm.service.TasksServiceImpl;
import tech.csm.dao.ProjectsDaoImpl;
import tech.csm.dao.TasksDaoImpl;
import tech.csm.util.DbUtil;

public class Runner {

	static Scanner sc=new Scanner(System.in);
	static Scanner scs=new Scanner(System.in);
	
public static void main(String[] args) {

		System.out.println(DbUtil.getMyConnection());
		ProjectsService projectsService =new ProjectsServiceImpl(new ProjectsDaoImpl());
		TasksService tasksService=new TasksServiceImpl(new TasksDaoImpl());
		
	int choice;
	do {
	
		System.out.println("1.Add task\n2.Change task\n3.Show project details\n4.Exit\nEnter your choice[1..4]");
		choice=sc.nextInt();
		
		switch(choice) {
		
		
		case 1:
			List<Projects> projects=projectsService.getAllProjects();
			for(Projects p:projects) {
				System.out.println(p);
			}
			System.out.println("Enter project id");
			int id=sc.nextInt();
			Projects p=projectsService.getProjectById(id);

			Tasks tasks=new Tasks();
			System.out.println("Enter task name");
			tasks.setTaskName(scs.nextLine());
			System.out.println("Hours taken");
			tasks.setHoursTaken(sc.nextInt());
			System.out.println(tasksService.addTask(tasks,p.getProjectId()));
			
			break;
		case 2:
			List<Tasks> task=tasksService.getAllTask();
			for(Tasks t:task) {
				System.out.println(t);
			}
			System.out.println("Enter task id you want to change[...You can only change task name and hours...]");
			id=sc.nextInt();
			System.out.println("Enter new task name");
			String newTask=scs.nextLine();
			System.out.println("Enter hours taken");
			int hours=sc.nextInt();
			System.out.println(tasksService.changeTasks(id,newTask,hours));
			break;
		case 3:
			projects=projectsService.showProjectDetails();
			for(Projects x:projects) {
				System.out.println(x);
			}

			
			break;
		case 4:
			DbUtil.closeMyConnection();
			break;
		default:
			System.out.println("Invalid choive");
		}
	}
	while(choice !=4);
	}

}
