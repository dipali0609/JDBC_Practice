package com.prepared;

import java.util.Scanner;

public class MainApp 
{
public static void main(String[] args) throws Exception
{
	Scanner sc=new Scanner(System.in);
	
	
	while(true)
	{
		System.out.println("1 Display Records \n2 Insert Records \n3 Update Records \n4 Delete Records");
		System.out.println("____________________________________________________________________________________");
		System.out.println("Enter Your Choice");
		int choice =sc.nextInt();
		switch(choice)
		{
		case 1:
			DatabaseOperation.DisplayRecords();
			break;
		case 2:
			DatabaseOperation.InsertReocrds();
			break;
		case 3: 
			DatabaseOperation.UpdateRecords();
			break;
		case 4:
			DatabaseOperation.DeleteRecords();
			break;
		}
		System.out.println("Do You Want To Continue Press 'y' for Yes Press 'n' for no");
		char ch=sc.next().toLowerCase().charAt(0);
		if(ch=='n')
		{
			break;
		}
		
	}
	System.out.println("Program is Terminated");
	
	
}
}
