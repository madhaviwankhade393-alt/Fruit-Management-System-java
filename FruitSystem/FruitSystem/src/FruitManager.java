package com.acc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.acc.exc.RecordNotFoundException;
import com.acc.services.FruitServicesImpl;
import com.fruit.Fruit;
    
public class FruitManager { 
	public static void main(String[]args) throws RecordNotFoundException{ 
		System.out.println("Welcome to Fruit Management System");
		System.out.println("Fruit Services");
		System.out.println("1.Add Fruit");
		System.out.println("2.Delete Fruit"); 	
		System.out.println("3.Search Fruit");
		System.out.println("4.Find All Fruits");
		System.out.println("5.Update your Fruit");
		System.out.println("6.Exit");
		System.out.println();
		
		System.out.println("Enter your choice");
		Scanner sc= new Scanner(System.in);
		int choice =sc.nextInt();

		 while(choice!=6) { 
		
		switch(choice) { 
		case 1 :System.out.println("Add your Fruit");
		FruitServicesImpl fsk=new FruitServicesImpl();
		fsk.add(); 
         
		break;
		
		case 2 :System.out.println("Delete your Fruit");
		FruitServicesImpl fsk2=new FruitServicesImpl();
		fsk2.delete();
		break;
		
		case 3 :System.out.println("Search your Fruit");
		FruitServicesImpl fsk3=new FruitServicesImpl();
			try {
				fsk3.serach();
			} catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		break;
 	
		case 4 :System.out.println("Total Fruits"); 
		List <Fruit> fruits=new ArrayList <Fruit>();  
		FruitServicesImpl fsk4=new FruitServicesImpl();
		System.out.println("_________________________________________________________________");
		System.out.println("|ID  |  FRUITNAME |   CATEGORY   |    PRICE  |      TASTE  ");
		System.out.println("_________________________________________________________________|");
		fruits=fsk4.findAll();
		for(Fruit f1:fruits) {
		System.out.println(f1);
		System.out.println("_________________________________________________________________|");
		}
		break;
	
		case 6:
		FruitServicesImpl fsk5=new FruitServicesImpl(); 
	    break;
		  
		case 5:System.out.println("Update your Fruit");
		FruitServicesImpl fsk6=new FruitServicesImpl();
		fsk6.update();
	     break;
	    
		default : System.out.println("Invalid choice");	
		break;
		}
		
		System.out.println();
		System.out.println("Enter your next choice:");
		choice =sc.nextInt();
		 }	 
		 System.out.println("Thank you For visiting");
     }
        
}
