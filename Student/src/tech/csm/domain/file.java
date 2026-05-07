package tech.csm.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class file {

	public static void main(String[] args) throws IOException {


		File f=new File("D:\\WEBD\\aditya.txt");
		f.createNewFile();
//		System.out.println(f);
		String s="\nAditya swain (ASE)";
		String s1="ITER";
		
		
		PrintStream ps=new PrintStream(f);
		ps.write(s1.getBytes());
		
		FileOutputStream fos=new FileOutputStream(f,true);
		fos.write(s.getBytes());
		
//		File [] s=f.listFiles();
//		for(File x:s) {
//		
//			if(x.isFile()) {
//				System.out.print(x.getName()+" ");
//
//			}
//			System.out.println(x.getName());
//		}
	}

}
