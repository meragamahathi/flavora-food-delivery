package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderItemDAO;
import com.food.model.OrderItem;
import com.food.utility.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO{
	private static final String INSERT_QUERY =
            "INSERT INTO orderitem(orderId,menuId,quantity,itemTotal) VALUES(?,?,?,?)";

    private static final String SELECT_QUERY =
            "SELECT * FROM orderitem WHERE orderItemId=?";

    private static final String UPDATE_QUERY =
            "UPDATE orderitem SET orderId=?,menuId=?,quantity=?,itemTotal=? WHERE orderItemId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM orderitem WHERE orderItemId=?";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM orderitem";
    
    @Override
    public void addOrderItem(OrderItem orderItem) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

            pstmt.setInt(1, orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getMenuId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getItemTotal());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public OrderItem getOrderItem(int orderItemId) {

        OrderItem orderItem = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY)) {

            pstmt.setInt(1, orderItemId);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                int orderId = res.getInt("orderId");
                int menuId = res.getInt("menuId");
                int quantity = res.getInt("quantity");
                double itemTotal = res.getDouble("itemTotal");

                orderItem = new OrderItem(orderItemId, orderId,menuId,quantity,itemTotal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItem;
    }
    
    @Override
    public void updateOrderItem(OrderItem orderItem) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

            pstmt.setInt(1, orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getMenuId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getItemTotal());
            pstmt.setInt(5, orderItem.getOrderItemId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deleteOrderItem(int orderItemId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

            pstmt.setInt(1, orderItemId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<OrderItem> getAllOrderItems() {

        List<OrderItem> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet res = stmt.executeQuery(SELECT_ALL_QUERY)) {

            while (res.next()) {

                int orderItemId = res.getInt("orderItemId");
                int orderId = res.getInt("orderId");
                int menuId = res.getInt("menuId");
                int quantity = res.getInt("quantity");
                double itemTotal = res.getDouble("itemTotal");

                OrderItem orderItem = new OrderItem(orderItemId,orderId,menuId,quantity,itemTotal);

                list.add(orderItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<OrderItem> getOrderItemsByOrderId(int orderId){

        List<OrderItem> list = new ArrayList<>();

        String sql = "SELECT * FROM orderitem WHERE orderId=?";

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, orderId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){

                OrderItem item = new OrderItem();

                item.setOrderItemId(rs.getInt("orderItemId"));
                item.setOrderId(rs.getInt("orderId"));
                item.setMenuId(rs.getInt("menuId"));
                item.setQuantity(rs.getInt("quantity"));
                item.setItemTotal(rs.getDouble("itemTotal"));

                list.add(item);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

}
