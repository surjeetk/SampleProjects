package com.test;

import java.sql.*;

public class BomTraversal {

	static String bom[][];
	
	public void laodBOM(){
		ResultSet rs;
		Statement stmt;
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","surjeet");
			 stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql="SELECT PARENT,CHILD FROM BOM";
			 rs=stmt.executeQuery(sql);
			rs.last();
			int noOfRows=rs.getRow();
			rs.beforeFirst();
			
			System.out.println("rows:"+noOfRows);
			bom=new String[noOfRows][2];
			
			int count=0;
			while(rs.next()){
				//System.out.println(rs.getString(1));
				bom[count][0]=rs.getString(1);
				bom[count][1]=rs.getString(2);
				count++;
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BomTraversal bomtraversal=new BomTraversal();
		bomtraversal.laodBOM();
		
		System.out.println(bom[3][1]);
	}

}
