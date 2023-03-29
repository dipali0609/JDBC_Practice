package com.edu1;

import java.util.Scanner;

public class MainJDBCApp 
{
public static void main(String[] args) throws Exception
{
	int ch;
	Scanner sc=new Scanner(System.in);
	
	while(true) {
		System.out.println("What operation you want to do?");
		System.out.println("1.Show records");
		System.out.println("2.Add Records");
		System.out.println("3.Update Records");
		System.out.println("4.Delete Records");
		System.out.println("Enter your choice");
		ch=sc.nextInt();
		switch(ch){
		case 1: DatabaseOperations.displayRecord();
		         break;
		case 2:DatabaseOperations.addEmployee();
		        break;
		case 3:DatabaseOperations.updateEmployee();
         break;
		case 4:DatabaseOperations.deleteEmployee();
		         break;
		}//switch
		System.out.println("Do you want to continue n to stop any other key to continue");
	   char choice=sc.next().charAt(0);
	   if(choice=='n')
	   {
		   break;
	   }
	}
	System.out.println("terminated");

}
}
