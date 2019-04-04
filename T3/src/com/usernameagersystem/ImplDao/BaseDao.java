package com.usernameagersystem.ImplDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private static Connection con;
		static{
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException cnfe){
	            System.out.println("driver nao encontrado: " + cnfe.getMessage());
	            
			}
	        catch(Exception e){
	            System.out.println(e.getMessage());
	           
	        }
		}
		
	public static Connection getConnection(){
		try{
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usernameagersystem?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC","root","password");
		}catch(Exception se){
			se.printStackTrace();
		}finally{
			
		}
		return con;
	}
	public static void closeALL(ResultSet rs,PreparedStatement ps,Connection con){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException se){
				se.printStackTrace();
			}catch(Exception e){
	            
	            e.printStackTrace();
			}
			
		}
		if(ps!=null){
			try{
				ps.close();
			}catch(SQLException se){
				se.printStackTrace();
			}catch(Exception e){
	            
	            e.printStackTrace();
			}
			
		}
		if(con!=null){
			try{
				con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}catch(Exception e){
	            
	            e.printStackTrace();
			}
			
		}
	}
}
