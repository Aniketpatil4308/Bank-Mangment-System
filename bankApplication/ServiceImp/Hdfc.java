package com.ap.bankApplication.ServiceImp;
 import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ap.bankApplication.Configure.HbUtil;
import com.ap.bankApplication.Service.*;
import com.ap.bankApplication.model.Account;

public class Hdfc implements Rbi{

	Scanner sc = new Scanner(System.in);
	
	
	
	
	@Override
	public void createAccount() {
		
		Account ac = new Account();
		
		System.out.println("Enter Account Holder Name :");
		ac.setAcName(sc.next()+sc.nextLine());
		
		System.out.println("Enter Account Holder Mobile Number :");
		ac.setMobileNo(sc.nextLong());
		
		System.out.println("Enter Account Holder AdharNo :");
		ac.setAdharNo(sc.nextLong());
		
		System.out.println("Enter Account Holder Pan Number :");
		ac.setPanNo(sc.next() + sc.nextLine());
		
		System.out.println("Enter Account Holder Address :");
		ac.setAddress(sc.next()+ sc.nextLine());
		
		System.out.println("Enter Account Holder Gender : ");
		ac.setGender(sc.next()+ sc.nextLine());
		
		System.out.println("Enter Account Holder Balance :");
		ac.setBalance(sc.nextDouble());
				
		SessionFactory sf = HbUtil.getSessionFactory();
		
		Session s1 = sf.openSession();
		
		Transaction tx = s1.beginTransaction();
	
		 Long acno = (Long) s1.save(ac);
		 
		 tx.commit();
		 
		 System.out.println("Acount Created SuccessFully .............!" +"Your Account Number is : "+acno);
		

		
	}

	@Override
	public void viewDetails() {
		
		
		SessionFactory sf = HbUtil.getSessionFactory();
		
		Session s1 = sf.openSession();
		
		System.out.println("Enter Account Number To view Detials : ");
		
		long uac = sc.nextLong();
		  Account ac = s1.get(Account.class, uac);
		
		  try {
		  if(uac == ac.getAcNo())
		  {
		  System.out.println("***************Account Holder Information ***********");
		  System.out.println("Account Number :" +ac.getAcNo());
		  System.out.println("Account Holder Name :" +ac.getAcName());
		  System.out.println("Account Address :" +ac.getAddress());
		  System.out.println("Account Adhar Number :" +ac.getAdharNo());
		  System.out.println("Account Pan No :" +ac.getPanNo());
		  System.out.println("Account Gender :" +ac.getGender());
		  System.out.println("Account Mobile Number :" +ac.getMobileNo());
		  System.out.println("Account Balance :" +ac.getBalance());
		  
		  System.out.println("**********************************************");
		  }
		}catch(Exception e)
		{
			System.out.println("Invalid Account Number ..........! ");
			System.out.println("Try Again ........!");
			viewDetails();
		}
	}

	@Override
	public void depositeMoney() {
		
	SessionFactory sf	 = HbUtil.getSessionFactory();
		
	 Session session= sf.openSession();
	
	 Transaction tx = session.beginTransaction();
		
	 System.out.println("Enter Account Number To Deposite Money :");
	 
	 
	 long uac = sc.nextLong();
	  Account ac = session.get(Account.class, uac);
	 
	  try {
	  if(uac == ac.getAcNo())
	  {
	  
	  System.out.println("Enter Deposite Amount :");
	  double uamt = sc.nextDouble();
	  
	  if(uamt >= 100 )
	  {
		  
		  double newbal = ac.getBalance() + uamt;
		  ac.setBalance(newbal);
		  session.update(ac);
		  
		  tx.commit();
		  
		  System.out.println(uamt+"Rs  Deposited SuccessFully............1");
		
	  }else
	  {
		  System.out.println("Sorry .....Minimum Deposite Amount is: 100rs");
		  
	  }
	  }
	  }catch(Exception e)
		{
			System.out.println("Invalid Account Number ..........! ");
			System.out.println("Try Again ........!");
			depositeMoney();
		}
	  
}
	  

	@Override
	public void withdrawMoney() {
		
		SessionFactory sf = HbUtil.getSessionFactory();
		
		 Session session= sf.openSession();
		
	Transaction tx	= session.beginTransaction();
		
	System.out.println("Enter Account Number To Withdraw Money :");
		
	long uac = sc.nextLong();
	
	         Account ac = session.get(Account.class, uac);
	
	         try {
	         if(uac == ac.getAcNo())
	         {
	System.out.println("Enter Withdraw Amount :");
	     double uamt  = sc.nextDouble();
	
	     double avlbal =ac.getBalance();
	     
	     if(uamt > avlbal)
	     {
	    	 
	    	 System.out.println("Insuficiant Balance .......!");
	    	 
	     }
	     else if(uamt >= 100 )
	     {
	    	 double Newbal = ac.getBalance() - uamt ;
	    	 		
	    	 ac.setBalance(Newbal);
	    	 session.update(ac);
	    	 tx.commit();
	    	 
	    	 System.out.println(uamt+"rs withdraw SuccessFully...........!");
	    	 System.out.println("Your Current Balance Is :"+ Newbal +"rs");
	    	 
	     }
	   
	          
	     else
	     {
	    	 System.out.println("Sorry !!!! Minimum Withdrawl Amount is : 100rs");
	     }
	     
	         }
	     }
	         catch(Exception e)
	 		{
				System.out.println("Invalid Account Number ..........! ");
				System.out.println("Try Again ........!");
				withdrawMoney();
			}
	
		
	}

	@Override
	public void updateDetails() {
		
		SessionFactory sf = HbUtil.getSessionFactory();
		
		 Session session = sf.openSession();
		
		 Transaction tx = session.beginTransaction();
		 
		 System.out.println("Enter Account Number To Update Details :");
		long uac = sc.nextLong(); 
		 Account ac = session.get(Account.class, uac);
		
		
		 try {
		 if(uac == ac.getAcNo())

		 {
		 System.out.println("Press 1 For Edit Name ");
		 System.out.println("Press 2 For Edit Address ");
		 System.out.println("Press 3 For Edit Mobile number ");
		 
		 System.out.println();
		 System.out.println("Enter Your Choise Here :");
		 Scanner sc = new Scanner(System.in);
		 
		  int user = sc.nextInt();
		 
		  switch(user)
		  {
		  
		  case 1 :
			  
			  System.out.println("Enter New Name :");
			  ac.setAcName(sc.next()+ sc.nextLine());
			  
			  System.out.println("Name Updated Successfully .......!");
			  
			  break;
		  
		  case 2 :
			  
			  System.out.println("Enter New Address : ");
			  ac.setAddress(sc.next()+ sc.nextLine());
			  
			  System.out.println("Address Updated SuccessFully .......!");
			  
			  break;
			  
		  case 3 :
			  
			  System.out.println("Enter New Mobile Number :");
			  ac.setMobileNo(sc.nextLong());
			  
			  System.out.println("Mobile Number Updated SuccessFully.........!");
			  
			  break;
		
			  
			  
		default :
			
			 System.out.println("Invalid Choise .........!");
			 
			 break;
					  
		  }
		  
		  tx.commit();		 
		 }
		 }
		 catch(NullPointerException e)
		 {
			 System.out.println("Invalid Account Number ...........!");
			 System.out.println("Try Again .............!");
			 updateDetails();
			
		 }
		 
	
	}

	@Override
	public void deleteAccount() {
		
		SessionFactory sf = HbUtil.getSessionFactory();
		
		
		Session se = sf.openSession();
		
		Transaction tx = se.beginTransaction();
		
		System.out.println("Enter Account Holder Account No To Delete Account : ");
		long uac = sc.nextLong();
		
		Account ac  = se.get(Account.class,uac);
		
		try {
		if(uac == ac.getAcNo())
		{
		se.delete(ac);

		tx.commit();
		
		System.out.println("Account Deleted SuccessFully....!");
		}
		}
		catch(Exception e)
		{
			System.out.println("Invalid Account Number ..........! ");
			System.out.println("Try Again ........!");
			deleteAccount();
		}
		
	}

	
	
	
	
	
}
