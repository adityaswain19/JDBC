package tech.csm;

public class largest {

	public static void main(String[] args) {

		System.out.println("Hello");

		try{
			int a =5/0;
			System.out.println(a);

		}
		catch(NullPointerException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {

			System.out.println("World");

		}
		
	}

}
