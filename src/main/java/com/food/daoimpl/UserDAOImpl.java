package com.food.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.UserDAO;
import com.food.model.User;
import com.food.utility.DBConnection;
public class UserDAOImpl implements UserDAO{
	private static final String INSERT_QUERY="INSERT INTO user(userName,password,email,"
			+ "address,role,status,createDate,lastLoginDate) Values(?,?,?,?,?,?,?,?)";
	private static final String LOGIN_QUERY="SELECT * FROM user where email=? and password=?";
	private static final String UPDATE_QUERY="UPDATE user SET userName=?,password=?,email=?,"
			+"  address=?,role=?,status=?,lastLoginDate=? where userId=? ";
	private static final String DELETE_USER="DELETE FROM user WHERE userId=? ";
	private static final String SELECT_ALL_QUERY="SELECT * FROM user";
 
	@Override
	public int addUser(User user) {
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(INSERT_QUERY);){
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			pstmt.setString(6, user.getStatus());
			pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			int i=pstmt.executeUpdate();
			return i;
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	   
	}
	
	@Override
	public User validateUser(String email, String password) {

	    User user = null;

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(LOGIN_QUERY)) {

	        pstmt.setString(1, email);
	        pstmt.setString(2, password);

	        ResultSet res = pstmt.executeQuery();

	        if (res.next()) {

	            int userId = res.getInt("userId");
	            String userName = res.getString("userName");
	            String userPassword = res.getString("password");
	            String userEmail = res.getString("email");
	            String address = res.getString("address");
	            String role = res.getString("role");
	            Timestamp createDate = res.getTimestamp("createDate");
	            Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");
	            String status=res.getString("status");

	            user = new User(
	                    userId,
	                    userName,
	                    userPassword,
	                    userEmail,
	                    address,
	                    role,
	                    status,
	                    createDate,
	                    lastLoginDate
	    
	            );
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}

	@Override
	public void updateUser(User user) {
		try(Connection connection=DBConnection.getConnection();
		    PreparedStatement pstmt=connection.prepareStatement(UPDATE_QUERY);)
		{
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			pstmt.setString(6, user.getStatus());
			pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(8, user.getUserId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteUser(int userId) {
		Connection connection=DBConnection.getConnection();
		try {
			PreparedStatement pstmt=connection.prepareStatement(DELETE_USER);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list=new ArrayList<User>();
		Connection connection=DBConnection.getConnection();

		
		try {
			Statement stmt = connection.createStatement();
			ResultSet res=stmt.executeQuery(SELECT_ALL_QUERY);
			while(res.next()) {
				int userId=res.getInt("userId");
				String userName=res.getString("userName");
				String email=res.getString("email");
				String password=res.getString("password");
				String address=res.getString("address");
				String role=res.getString("role");
				String status=res.getString("status");
				Timestamp createDate=res.getTimestamp("createDate");
	            Timestamp lastLoginDate=res.getTimestamp("lastLoginDate");
	            User user=new User(userId, userName,password, email, address, role, status, createDate, lastLoginDate);
	            list.add(user);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public User getUserByEmail(String email) {
		User user=null;
		String sql="SELECT * FROM User WHERE email= ?";
		try(Connection connection=DBConnection.getConnection();
		    PreparedStatement pstmt=connection.prepareStatement(sql)){
			
			pstmt.setString(1, email);
			ResultSet rs=pstmt.executeQuery();
			 if(rs.next()) {
				 user=new User();
				 user.setUserId(rs.getInt("UserId"));
				 user.setUserName(rs.getString("Username"));
				 user.setPassword(rs.getString("Password"));
				 user.setEmail(rs.getString("email"));
				 user.setAddress(rs.getString("Address"));
				 user.setRole(rs.getString("Role"));
				 user.setStatus(rs.getString("status"));
				 user.setCreateDate(rs.getTimestamp("createDate"));
				 user.setLastLoginDate(rs.getTimestamp("lastLoginDate"));
				 
			 }
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	public User getUserById(int userId){

	    User user = null;

	    String sql = "SELECT * FROM user WHERE userId=?";

	    try(Connection con = DBConnection.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(sql)){

	        pstmt.setInt(1, userId);

	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next()){

	            user = new User();

	            user.setUserId(rs.getInt("userId"));
	            user.setUserName(rs.getString("userName"));
	            user.setPassword(rs.getString("password"));
	            user.setEmail(rs.getString("email"));
	            user.setAddress(rs.getString("address"));
	            user.setRole(rs.getString("role"));
	            user.setStatus(rs.getString("status"));
	            user.setCreateDate(rs.getTimestamp("createDate"));
	            user.setLastLoginDate(rs.getTimestamp("lastLoginDate"));
	        }

	    }catch(Exception e){
	        e.printStackTrace();
	    }

	    return user;
	}
	
	public void updateUserStatus(int userId, String status) {

	    String sql = "UPDATE user SET status=? WHERE userId=?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setString(1, status);
	        pstmt.setInt(2, userId);

	        int rows = pstmt.executeUpdate();

	        System.out.println("Rows Updated = " + rows);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public int getUserCount() {

	    int count = 0;

	    String sql = "SELECT COUNT(*) FROM user";

	    try(Connection con = DBConnection.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery()) {

	        if(rs.next()) {
	            count = rs.getInt(1);
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return count;
	}
	
	@Override
	public User getUser(int userId) {

	    User user = null;

	    String sql = "SELECT * FROM user WHERE userId=?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setInt(1, userId);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {

	            user = new User();

	            user.setUserId(rs.getInt("userId"));
	            user.setUserName(rs.getString("userName"));
	            user.setEmail(rs.getString("email"));
	            user.setAddress(rs.getString("address"));
	            user.setRole(rs.getString("role"));
	            user.setStatus(rs.getString("status"));
	            user.setCreateDate(rs.getTimestamp("createDate"));
	            user.setLastLoginDate(rs.getTimestamp("lastLoginDate"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}
	
	public List<User> getAllDeliveryAgents(){

	    List<User> agents = new ArrayList<>();

	    String sql = "SELECT * FROM User WHERE role='DeliveryAgent'";

	    try(Connection con = DBConnection.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(sql)){

	        ResultSet rs = pstmt.executeQuery();

	        while(rs.next()){

	            User user = new User();

	            user.setUserId(rs.getInt("userId"));
	            user.setUserName(rs.getString("userName"));
	            user.setEmail(rs.getString("email"));

	            agents.add(user);
	        }

	    }catch(Exception e){
	        e.printStackTrace();
	    }

	    return agents;
	}
	
}


