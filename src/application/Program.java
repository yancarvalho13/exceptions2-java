package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		Boolean invalidInput = false;
		do {
			try {
				System.out.println("Enter account data");

				System.out.print("Number: ");
				int number = scan.nextInt();
				scan.nextLine();
				System.out.print("Holder: ");
				String holder = scan.nextLine();
				System.out.print("Initial balance: ");
				Double balance = scan.nextDouble();
				System.out.print("Withdraw limit: ");
				Double withdrawLimit = scan.nextDouble();

				Account acc = new Account(number, holder, balance, withdrawLimit);

				System.out.print("Enter the amount for withdraw: ");
				Double amount = scan.nextDouble();
				acc.withdraw(amount);
				System.out.println(acc);

				invalidInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input type");
				scan.nextLine();
			} catch (DomainExceptions e) {
				System.out.println(e.getMessage());
			}
		} while (!invalidInput);
		
		scan.close();
	}

}
