package model.entities;

import model.exceptions.DomainExceptions;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws DomainExceptions {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void deposit(Double amount) {

	}

	public void withdraw(Double amount) throws DomainExceptions {
		if (amount > withdrawLimit) {
			throw new DomainExceptions("Withdraw error: the amount exceeds withdraw limit");
		}
		if (balance < amount) {
			throw new DomainExceptions("With draw error: not enough balance");
		}
		balance -= amount;
	}

	public String toString() {
		return "New balance: " + String.format("%.2f", balance);

	}

}
