package com.fruit;
import java.util.Scanner;
public class Fruit {
	
	int id;
	String name;
	String category;
	int price;
	String taste;
	public Fruit(){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter id");
		int id1=sc.nextInt();
		this.id=id1;
		
		System.out.println("Enter name");
        String name=sc.next(); 	
        this.name =name;
		
		System.out.println("Enter category");
         String category=sc.next(); 	
         this.category =category;
         
         System.out.println("Enter price");
	     int price=sc.nextInt();
	     this.price=price;
	     
	     System.out.println("Enter taste");
         String taste=sc.next();
         this.taste=taste;
    }
	public Fruit(int a) {
		
	}
	
	public Fruit(int id,String name ,String category, int price, String taste) {
		super();
		this.id = id;
		this.name=name;
		this.category = category;
		this.price = price;
		this.taste = taste;
	}
	
	@Override
	public String toString() {
		return "|  " + id + " |" + name + "       |" + category + "      |" + price + "     |" + taste+"    |";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the taste
	 */
	public String getTaste() {
		return taste;
	}
	/**
	 * @param taste the taste to set
	 */
	public void setTaste(String taste) {
		this.taste = taste;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	
	 
	
	

}
