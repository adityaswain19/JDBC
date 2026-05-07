package tech.csm.runner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import tech.csm.dao.BlogsDaoImpl;
import tech.csm.dao.PostDaoImpl;
import tech.csm.entity.Blogs;
import tech.csm.entity.Posts;
import tech.csm.service.BlogsService;
import tech.csm.service.BlogsServiceImpl;
import tech.csm.service.PostService;
import tech.csm.service.PostServiceImpl;
import tech.csm.util.DbUtil;


public class Runner {

	static Scanner sc = new Scanner(System.in);
	static Scanner scs = new Scanner(System.in);
    static BlogsService blogsService =new BlogsServiceImpl(new BlogsDaoImpl());
    static PostService postService=new PostServiceImpl(new PostDaoImpl());
	
	public static void main(String[] args) {
		System.out.println(DbUtil.getMyConnection());
int choice;
		
		do {
			System.out.println("\n1.Create post\n2.Delete post \n3.Show all posts\n4.Search post\n5.Exit\nEnter your choice [1..5] :");
			choice = sc.nextInt();
			switch (choice) {
			case 1:

				Posts posts=new Posts();
				System.out.println("Enter post id");
			    posts.setPostId(sc.nextInt());
				System.out.println("Enter content");
				posts.setContent(scs.nextLine());
				posts.setCreatedOn(new Date());
				List<Blogs> l=blogsService.getAllBlogs();
				
				for(Blogs b:l) {
					System.out.println(b);
				}
				System.out.println("Enter blog id from the above list ");

				int id=sc.nextInt();
				Blogs blogs=blogsService.getBlogById(id);	
				posts.setBlogs(blogs);
//				System.out.println(posts);
				System.out.println(postService.addPost(posts));
				
				

				break;
			case 2:
                List<Posts> p=postService.getAllPosts();
				
				for(Posts x:p) {
					System.out.println(x);
				}
				System.out.println("Enter post id to delete");
				int postId=sc.nextInt();
				posts=postService.getPostById(postId);

				
				System.out.println(postService.deletePost(posts.getPostId()));
				break;
			case 3:
				p=postService.getAllPosts();
				
				for(Posts x:p) {
					System.out.println(x);
				}
				break;
			case 4:

				break;
			case 5:
				DbUtil.getMyConnection();
				break;
			default:
				System.out.println("invalid option!!!!");

			}
		} while (choice != 5);

	}
}
