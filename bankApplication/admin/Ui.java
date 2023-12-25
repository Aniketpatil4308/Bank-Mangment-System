package com.ap.bankApplication.admin;
import com.ap.bankApplication.Service.*;
import com.ap.bankApplication.ServiceImp.*;
import java.util.Scanner;

public class Ui {
	
	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);

		Rbi rbi = new Hdfc();

		while (true) {
			System.out.println("********WelCome To The Bank Application*******");
			System.out.println("Enter 1 For create Account");
			System.out.println("Enter 2 For view  Account Details");
			System.out.println("Enter 3 For Deposite Money");
			System.out.println("Enter 4 For  WithDrawl Money");
			System.out.println("Enter 5 For Update Account Details");
			System.out.println("Enter 6 For Delete  Account");
			System.out.println("Enter 7 For Exit From The Application");
			System.out.println("************************************************");
			System.out.println();
			
			System.out.println("Enter Your Choise :");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				rbi.createAccount();
				break;

			case 2:
				rbi.viewDetails();
				break;

			case 3:
				rbi.depositeMoney();
				break;

			case 4:
				rbi.withdrawMoney();
				break;

			case 5:
				rbi.updateDetails();
				break;

			case 6:
				rbi.deleteAccount();
				break;

			case 7:
				System.out.println("Thank You For Banking With us.....!");
				System.exit(0);
				break;

			default:
				System.out.println("Wrong Choice Selcted.....!");
				break;
			}
		}
	}


}
