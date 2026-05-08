package tech.csm.bankapp.domain;

import tech.csm.bankapp.util.BankUtil;

public class BankAccount {
	private String accountNumber;
	private String name;
	private Address addr;
	private String accountType;
	private double balance;
	private int noOfTransactions;
	
	public BankAccount(String name, Address addr, String accountType, double balance) {
		super();
		this.accountNumber=BankUtil.generateUniqueBankAccountNumber();
		this.name = name;
		this.addr = addr;
		this.accountType = accountType;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getNoOfTransactions() {
		return noOfTransactions;
	}
	public void setNoOfTransactions(int noOfTransactions) {
		this.noOfTransactions = noOfTransactions;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", name=" + name + ", addr=" + addr + ", accountType="
				+ accountType + ", balance=" + balance + ", noOfTransactions=" + noOfTransactions + "]";
	}
	
	public String accountDeposit(double newBalance) {
		balance+=newBalance;
		noOfTransactions++;
		return newBalance+" deposited successfully !!";
		
	}
	public String balanceWithdraw(double amount) {
		if(amount<=balance) {
			balance-=amount;
			noOfTransactions++;
			return amount+" withdrawal successful !!";
		}
		return "insufficeint banalce !!";
	}
	
	public String changeAddress(Address newAddress) {
		addr=newAddress;
		return "change of address successful !!";
	}
	
	
	
	
}
