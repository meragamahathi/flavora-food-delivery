package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.RestaurantDAO;
import com.food.model.Restaurant;
import com.food.utility.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {
	 private static final String INSERT_QUERY =
	            "INSERT INTO restaurant(name,cuisineType,deliveryTime,address,adminUserId,rating,isActive,imageUrl,priceForTwo) VALUES(?,?,?,?,?,?,?,?,?)";

	    private static final String SELECT_QUERY =
	            "SELECT * FROM restaurant WHERE restaurantId=?";

	    private static final String UPDATE_QUERY =
	            "UPDATE restaurant SET name=?,cuisineType=?,deliveryTime=?,address=?,adminUserId=?,rating=?,isActive=?,imageUrl=?,priceForTwo=? WHERE restaurantId=?";

	    private static final String DELETE_QUERY =
	            "DELETE FROM restaurant WHERE restaurantId=?";

	    private static final String SELECT_ALL_QUERY =
	            "SELECT * FROM restaurant";
	    
	    @Override
	    public void addRestaurant(Restaurant restaurant) {

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

	            pstmt.setString(1, restaurant.getName());
	            pstmt.setString(2, restaurant.getCuisineType());
	            pstmt.setInt(3, restaurant.getDeliveryTime());
	            pstmt.setString(4, restaurant.getAddress());
	            pstmt.setInt(5, restaurant.getAdminUserId());
	            pstmt.setDouble(6, restaurant.getRating());
	            pstmt.setBoolean(7, restaurant.isActive());
	            pstmt.setString(8, restaurant.getImageUrl());
	            pstmt.setInt(9, restaurant.getPriceForTwo());

	            pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Override
	    public Restaurant getRestaurant(int restaurantId) {

	        Restaurant restaurant = null;

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY)) {

	            pstmt.setInt(1, restaurantId);

	            ResultSet res = pstmt.executeQuery();

	            while (res.next()) {

	                String name = res.getString("name");
	                String cuisineType = res.getString("cuisineType");
	                int deliveryTime = res.getInt("deliveryTime");
	                String address = res.getString("address");
	                int adminUserId = res.getInt("adminUserId");
	                double rating = res.getDouble("rating");
	                boolean isActive = res.getBoolean("isActive");
	                String imageUrl=res.getString("imageUrl");
	                int priceForTwo=res.getInt("priceForTwo");

	                restaurant = new Restaurant(restaurantId,name,cuisineType,deliveryTime,address, adminUserId,rating,isActive,imageUrl,priceForTwo);
	            }

	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return restaurant;
	    }
	    
	    @Override
	    public void updateRestaurant(Restaurant restaurant) {

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

	            pstmt.setString(1, restaurant.getName());
	            pstmt.setString(2, restaurant.getCuisineType());
	            pstmt.setInt(3, restaurant.getDeliveryTime());
	            pstmt.setString(4, restaurant.getAddress());
	            pstmt.setInt(5, restaurant.getAdminUserId());
	            pstmt.setDouble(6, restaurant.getRating());
	            pstmt.setBoolean(7, restaurant.isActive());
	            pstmt.setString(8, restaurant.getImageUrl());
	            pstmt.setInt(9, restaurant.getPriceForTwo());
	            pstmt.setInt(10, restaurant.getRestaurantId());

	            pstmt.executeUpdate();

	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Override
	    public void deleteRestaurant(int restaurantId) {

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

	            pstmt.setInt(1, restaurantId);

	            pstmt.executeUpdate();

	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Override
	    public List<Restaurant> getAllRestaurants() {

	        List<Restaurant> list = new ArrayList<>();

	        try (Connection con = DBConnection.getConnection();
	             Statement stmt = con.createStatement();
	             ResultSet res = stmt.executeQuery(SELECT_ALL_QUERY)) {

	            while (res.next()) {

	                int restaurantId = res.getInt("restaurantId");
	                String name = res.getString("name");
	                String cuisineType = res.getString("cuisineType");
	                int deliveryTime = res.getInt("deliveryTime");
	                String address = res.getString("address");
	                int adminUserId = res.getInt("adminUserId");
	                double rating = res.getDouble("rating");
	                boolean isActive = res.getBoolean("isActive");
	                String imageUrl=res.getString("imageUrl");
	                int priceForTwo=res.getInt("priceForTwo");

	                Restaurant restaurant = new Restaurant(restaurantId,name,cuisineType,deliveryTime,address,adminUserId,rating,isActive,imageUrl,priceForTwo);
	                list.add(restaurant);
	            }

	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	    
	    @Override
	    public int getRestaurantCount() {

	        int count = 0;

	        String sql = "SELECT COUNT(*) FROM restaurant";

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
	    
}
	    

