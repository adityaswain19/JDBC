package tech.csm.bankapp.util;

public class BankUtil {
 
	private static int accNo=1000;
	public static String generateUniqueBankAccountNumber() {
		return "BA" + accNo++;
		
	}
}
