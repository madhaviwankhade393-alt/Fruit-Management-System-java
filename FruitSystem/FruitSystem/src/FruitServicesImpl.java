package com.acc.services;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.acc.db.DBConnection;
import com.acc.exc.RecordNotFoundException;
import com.fruit.Fruit; 

public class FruitServicesImpl implements FruitServices {

	@Override
	public void add() {
		Fruit f1=new Fruit(); 
		Connection con=null;
		PreparedStatement psmt=null;
		try {
		 	con=DBConnection.getDBConnection();	 
			psmt=con.prepareStatement("insert into Fruits(id,name,category,taste,price)values(?,?,?,?,?)");
			psmt.setInt(1,f1.getId()); 
			psmt.setString(2, f1.getName()); 
			psmt.setString(3,f1.getCategory());
			psmt.setString(4,f1.getTaste());
			psmt.setInt(5,f1.getPrice());
			psmt.executeUpdate(); 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
		
			try {
				if(con!=null)
				{

				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fruit Added Successfully");
	}

	@Override
	public List<Fruit> findAll() {
		Connection con =null;
		Statement stmt=null;
		ResultSet rs=null; 
		List<Fruit> fsk=new ArrayList<Fruit>();   	
		try {
			con=DBConnection.getDBConnection(); 
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from Fruits");
			while(rs.next()) {
				fsk.add(new Fruit(rs.getInt("Id"),rs.getString("name"),rs.getNString("category"),rs.getInt("price"),rs.getString("taste")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			try {
				 if(rs!=null) {
	                     rs.close();
				  }else if(con!=null) {
							con.close();
				   }
			   } catch (SQLException e) {
					e.printStackTrace();
					}
			}		
		
		return fsk;
	}

	@Override
	public void delete() {
		System.out.println("Enter fruit id for deleting");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		Connection con=null;
		PreparedStatement psmt=null;
		List <Fruit> fks=new ArrayList<Fruit>();		
		try {
			con= DBConnection.getDBConnection();
			psmt=con.prepareStatement("delete from Fruits where id=?");
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				if(con!=null)
				{

				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		 
	System.out.println("Fruit Deleted Successffully");
	} 

	@Override
	public void update() {
		System.out.println("Enter Fruit id to update your Fruit");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		sc.nextLine();
		Fruit f2=new Fruit(0); 
		f2.setId(id); 	 
		System.out.println("now you can update your details");
		System.out.println("Enter new Name:");
		f2.setName(sc.nextLine());
		System.out.println("Enter new Category:");
		f2.setCategory(sc.nextLine());
		System.out.println("Enter new Taste:");
		f2.setTaste(sc.nextLine());
		System.out.println("Enter new Price:");
		f2.setPrice(sc.nextInt());
		
		Connection con=null;
		PreparedStatement psmt=null;
		try { 
			con=DBConnection.getDBConnection();
			psmt=con.prepareStatement("update Fruits set name=?,category=?,taste=?,price=? where id=?");
       		psmt.setInt(1, id); 
//			psmt.setInt(1,f2.getId());  
			psmt.setString(1,f2.getName()); 
			psmt.setString(2,f2.getCategory());
			psmt.setString(3,f2.getTaste());
			psmt.setInt(4,f2.getPrice());
			psmt.setInt(5, f2.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
		
			try {
				if(con!=null)
				{

				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fruit Updated Successfully"); 
	}
// Search Fruit
	@Override
	public Fruit serach() throws RecordNotFoundException {
		System.out.println("Enter Fruit id to search your Fruit");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		Connection con =null; 
		Statement stmt=null;
		PreparedStatement pstmt=null;
		Fruit fsk=new Fruit(1); 	
		ResultSet rs=null;  
		try {
			con=DBConnection.getDBConnection();
			pstmt=con.prepareStatement("select * from Fruits where id=?");/* create Statement*/
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();/*Execute query*/
			if(rs.next()) {
			fsk=new Fruit(rs.getInt("id"),rs.getString("name"),rs.getNString("category"),rs.getInt("price"),rs.getString("taste"));			 
		     System.out.println(fsk);
		     }
			else {
				throw new RecordNotFoundException("Record not Found");
			}
			
		} catch (SQLException e) { 
			
			e.printStackTrace(); 
		}finally {
			try {
				if(rs!=null){
	              rs.close();/*Close connection*/
	             }else if(con!=null) {
		            con.close();
	                 }
          } catch (SQLException e) {
	          e.printStackTrace(); 
          } 
    }		 
		return fsk;
	}

	@Override
	public void exit1() {
		System.out.println("Exit"); 	
		System.exit(0);
	} 
	
}
