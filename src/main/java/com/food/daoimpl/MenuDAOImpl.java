package com.food.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.MenuDAO;
import com.food.model.Menu;
import com.food.utility.DBConnection;

public class MenuDAOImpl implements MenuDAO{
	
	private static final String INSERT_QUERY =
            "INSERT INTO menu(restaurantId,itemName,description,price,isAvailable,category,imageUrl) VALUES(?,?,?,?,?,?,?)";

    private static final String SELECT_QUERY =
            "SELECT * FROM menu WHERE menuId=?";

    private static final String UPDATE_QUERY =
            "UPDATE menu SET restaurantId=?,itemName=?,description=?,price=?,isAvailable=?,category=?,imageUrl=? WHERE menuId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM menu WHERE menuId=?";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM menu";
    
    private static final String GET_ALL_MENUS_BY_RESTAURANT =
            "SELECT * FROM menu WHERE restaurantId = ?";
    
    @Override
    public void addMenu(Menu menu){

        try(Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setBoolean(5, menu.isAvailable());
            pstmt.setString(6, menu.getCategory());
            pstmt.setString(7,menu.getImageUrl());

            pstmt.executeUpdate();

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Menu getMenu(int menuId) {

        Menu menu = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY)) {

            pstmt.setInt(1, menuId);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
            
            	
                int restaurantId = res.getInt("restaurantId");
                String itemName = res.getString("itemName");
                String description = res.getString("description");
                double price = res.getDouble("price");
                boolean isAvailable = res.getBoolean("isAvailable");
                String category = res.getString("category");
                String imageUrl=res.getString("imageUrl");
                

                menu = new Menu(menuId,restaurantId,itemName,description,price, isAvailable, category,imageUrl);
                
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menu;
    }
    
    @Override
    public void updateMenu(Menu menu) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setBoolean(5, menu.isAvailable());
            pstmt.setString(6, menu.getCategory());
            pstmt.setString(7, menu.getImageUrl());
            pstmt.setInt(8, menu.getMenuId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deleteMenu(int menuId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

            pstmt.setInt(1, menuId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Menu> getAllMenus() {

        List<Menu> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet res = stmt.executeQuery(SELECT_ALL_QUERY)) {

            while (res.next()) {

                int menuId = res.getInt("menuId");
                int restaurantId = res.getInt("restaurantId");
                String itemName = res.getString("itemName");
                String description = res.getString("description");
                double price = res.getDouble("price");
                boolean isAvailable = res.getBoolean("isAvailable");
                String category = res.getString("category");
                String imageUrl=res.getString("imageUrl");

                Menu menu = new Menu(menuId,restaurantId,itemName,description,price,isAvailable,category,imageUrl);

                list.add(menu);
            }

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    @Override
    public List<Menu> getAllMenusByRestaurant(int restaurantId) {

        List<Menu> menus = new ArrayList<>();

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(GET_ALL_MENUS_BY_RESTAURANT);
        ) {

            pstmt.setInt(1, restaurantId);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                Menu menu = new Menu(
                		res.getInt("menuId"),
                        res.getInt("restaurantId"),
                        res.getString("itemName"),
                        res.getString("description"),
                        res.getDouble("price"),
                        res.getBoolean("isAvailable"),
                        res.getString("category"),
                        res.getString("imageUrl")

                );

                menus.add(menu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menus;
    }
    
    @Override
    public int getMenuCount() {

        int count = 0;

        String sql = "SELECT COUNT(*) FROM menu";

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
