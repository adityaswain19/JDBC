package tech.csm.bankapp.runner;

import java.util.*;
import tech.csm.bankapp.domain.Address;
import tech.csm.bankapp.domain.BankAccount;

public class BankRunner {
	private static Scanner sc = new Scanner(System.in);
	private static Scanner scs = new Scanner(System.in);

	public static void main(String[] args) {
	

		System.out.println("How many account you want to create:");
		int n = sc.nextInt();
		BankAccount[] accounts = new BankAccount[n];
		System.out.println("Enter " + n + " account details: ");
		for (int i = 0; i < n; i++) {
			accounts[i] = createNewAccount();
		}
		int choice;
		do {
			System.out
					.println("1.Deposit\n2.Withdraw\n3.Display\n4.Change Address\n5.Exit\nEnter your Choice [1..5] : ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter account number:");
				String accountNo = scs.nextLine();
				BankAccount dAccount = null;
				for (BankAccount x : accounts) {
					if (x.getAccountNumber().equals(accountNo))
						dAccount = x;
				}

				System.out.println("Enter deposite amount:");
				double dAmount = sc.nextDouble();
				System.out.println(dAccount.accountDeposit(dAmount));
				break;

			case 2:
				System.out.println("Enter account number:");
				accountNo = scs.nextLine();
				BankAccount aAccount = null;
				for (BankAccount x : accounts) {
					if (x.getAccountNumber().equals(accountNo))
						aAccount = x;
				}

				System.out.println("Enter amount for withdrawal:");
				double aAmount = sc.nextDouble();
				System.out.println(aAccount.balanceWithdraw(aAmount));
				break;
			case 3:
				for (BankAccount x : accounts)
					System.out.println(x);
				break;

			case 4:
				System.out.println("Enter account number:");
				accountNo = scs.nextLine();
				aAccount = null;
				for (BankAccount x : accounts) {
					if (x.getAccountNumber().equals(accountNo))
						aAccount = x;
				}
				System.out.println("Enter new address (houseno, lane, city) :");
				int houseNo = sc.nextInt();
				String lane = scs.nextLine();
				String city = scs.nextLine();
				if(aAccount !=null)
				System.out.println(aAccount.changeAddress(new Address(houseNo,lane,city)));
				else
					System.out.println("Account not found!!");
				
				break;
			case 5:
				break;
			}
		} while (choice != 5);

	}

	private static BankAccount createNewAccount() {
		System.out.println("Enter account holders name: ");
		String name = scs.nextLine();
		System.out.println("Enter address (houseno, lane, city) :");
		int houseNo = sc.nextInt();
		String lane = scs.nextLine();
		String city = scs.nextLine();
		System.out.println("Enter account type (savings or current) :");
		String accountType = scs.nextLine();
		System.out.println("Enter opening account balance:");
		double accountBalance = sc.nextDouble();
		return new BankAccount(name, new Address(houseNo, lane, city), accountType, accountBalance);
	}

}
