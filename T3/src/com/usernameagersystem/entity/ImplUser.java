package com.usernameagersystem.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.usernameagersystem.ImplDao.BaseDao;

public class ImplUser {
	//private List<User> UserList;
	//private User user;
	public boolean login(User user){
		boolean flag=false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		con=BaseDao.getConnection();
		try{
			
			ps=con.prepareStatement("select * from t_user where username=? and userpassword=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setName(rs.getString(4));
				user.setNic(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setAge(rs.getInt(7));
				user.setEmail(rs.getString(8));
				user.setPhone(rs.getString(9));
				user.setSelfshow(rs.getString(10));
				user.setRoleId(rs.getInt(11));
				flag=true;
			}}catch(SQLException sql){
	            System.out.println("SQLException: " + sql.getMessage());
	            System.out.println("SQLState: " + sql.getSQLState());
	            System.out.println("Erro: " + sql.getErrorCode());
	            System.out.println("StackTrace: " + sql.getStackTrace());
	        }
	        catch(Exception e){
	            System.out.println(e.getMessage());
	        }finally{
				BaseDao.closeALL(rs, ps, con);
			}
		return flag;
	}
	
	//找出所有一班成員
	public List findAllUsers(){
		List userList=new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		con=BaseDao.getConnection();
		try{
			System.out.print("進入ImplUser.findUsers...");
			ps=con.prepareStatement("select * from t_user where roleId=0");
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setName(rs.getString(4));
				user.setNic(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setAge(rs.getInt(7));
				user.setEmail(rs.getString(8));
				user.setPhone(rs.getString(9));
				user.setSelfshow(rs.getString(10));
				user.setRoleId(rs.getInt(11));
				userList.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return userList;
		
	}
	//查詢所有管理員
	public List findAllAdmins(){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List adminList=new ArrayList();
		con=BaseDao.getConnection();
		
		try{
			ps=con.prepareStatement("select * from t_user where roleId=1");
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setName(rs.getString(4));
				user.setNic(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setAge(rs.getInt(7));
				user.setEmail(rs.getString(8));
				user.setPhone(rs.getString(9));
				user.setSelfshow(rs.getString(10));
				user.setRoleId(rs.getInt(11));
				adminList.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
		
		}
		return adminList;
	}
	
	public User selectUserInfo(int id){
		User userinfo=new User();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		con=BaseDao.getConnection();
		try{
			System.out.print(id);
			ps=con.prepareStatement("select * from t_user where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				userinfo.setId(rs.getInt(1));
				userinfo.setUsername(rs.getString(2));
				userinfo.setPassword(rs.getString(3));
				userinfo.setName(rs.getString(4));
				userinfo.setNic(rs.getString(5));
				userinfo.setSex(rs.getString(6));
				userinfo.setAge(rs.getInt(7));
				userinfo.setEmail(rs.getString(8));
				userinfo.setPhone(rs.getString(9));
				userinfo.setSelfshow(rs.getString(10));
				userinfo.setRoleId(rs.getInt(11));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return userinfo;
		
	}
	
	
	public int modifyUserInfo(User userinfo){
		int num=0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		con=BaseDao.getConnection();
		try{
			System.out.print(userinfo.getUsername());
			System.out.print(userinfo.getNic());
			ps=con.prepareStatement("UPDATE t_user set "
					+ "nic=?,sex=?,age=?,email=?,phone=?,selfshow=?"
					+ "where id=?");
			ps.setString(1,userinfo.getNic());
			ps.setString(2,userinfo.getSex());
			ps.setInt(3,userinfo.getAge());
			ps.setString(4,userinfo.getEmail());
			ps.setString(5,userinfo.getPhone());
			ps.setString(6,userinfo.getSelfshow());
			ps.setInt(7,userinfo.getId());
			num=ps.executeUpdate();
			System.out.print(num+"代表修改成功");
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
		
	}
	public int getUserid(String username, String password) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		con=BaseDao.getConnection();
		int id=0;
		try{
			ps=con.prepareStatement("select id from t_user where username=? AND userpassword=?");
			ps.setString(1,username);
			ps.setString(2,password);
			rs=ps.executeQuery();
			while(rs.next()){
				id=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
		
		}
		return id;
	}


	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		con=BaseDao.getConnection();
		int count=0;
		try{
			ps=con.prepareStatement("delete from t_user where id=?");
			ps.setInt(1,id);
			count=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
		
		}
		return count;
	}


	public int addUser(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		con=BaseDao.getConnection();
		int num=0;
		try{
			ps=con.prepareStatement("insert into t_user values(null,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getName());
			ps.setString(4,user.getNic());
			ps.setString(5,user.getSex());
			ps.setInt(6,user.getAge());
			ps.setString(7,user.getEmail());
			ps.setString(8,user.getPhone());
			ps.setString(9,user.getSelfshow());
			ps.setInt(10,user.getRoleId());
			num=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
		
		}
		return num;

	}


	public List findNewUsers() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List newuserList=new ArrayList();
		con=BaseDao.getConnection();
		
		try{
			ps=con.prepareStatement("select * from t_user where roleId=0 order by id desc limit 5");
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setName(rs.getString(4));
				user.setNic(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setAge(rs.getInt(7));
				user.setEmail(rs.getString(8));
				user.setPhone(rs.getString(9));
				user.setSelfshow(rs.getString(10));
				user.setRoleId(rs.getInt(11));
				newuserList.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
		
		}
		return newuserList;
	
	}


	public int addAdmin(User admin) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		con=BaseDao.getConnection();
		int num=0;
		try{
			ps=con.prepareStatement("insert into t_user values(null,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getName());
			ps.setString(4, admin.getNic());
			ps.setString(5, admin.getSex());
			ps.setInt(6, admin.getAge());
			ps.setString(7, admin.getEmail());
			ps.setString(8, admin.getPhone());
			ps.setString(9, admin.getSelfshow());
			ps.setInt(10, admin.getRoleId());
			num=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
		
		}
		return num;
	}


	public int getUserroleId(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		con=BaseDao.getConnection();
		int roleid=0;
		try{
			ps=con.prepareStatement("select roleId from t_user where id=? ");
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next()){
				roleid=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
		
		}
		return roleid;
	}
}

