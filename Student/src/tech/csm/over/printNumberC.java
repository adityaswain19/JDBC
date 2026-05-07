package tech.csm.over;

public class printNumberC extends printNumParent {

	int j;
	public printNumberC(int i,int j) {
		super(i);
		this.j=j;
		
	}
	public void printNum(int i) {
		System.out.println("Child "+i);
	}
}
