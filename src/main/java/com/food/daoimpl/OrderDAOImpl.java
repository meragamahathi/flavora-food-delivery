package com.food.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderDAO;
import com.food.model.Order;
import com.food.utility.DBConnection;

public class OrderDAOImpl implements OrderDAO{
	private static final String INSERT_QUERY =
            "INSERT INTO `order`(userId,restaurantId,orderDate,totalAmount,status,paymentMethod,paymentId,paymentStatus) VALUES(?,?,?,?,?,?,?,?)";

    private static final String SELECT_QUERY =
            "SELECT * FROM `order` WHERE orderId=?";

    private static final String UPDATE_QUERY =
            "UPDATE `order` SET userId=?,restaurantId=?,totalAmount=?,status=?,paymentMethod=?,paymentId=?,paymentStatus=?  WHERE orderId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM `order` WHERE orderId=?";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM `order` ";
    
    @Override
    public int addOrder(Order order) {
    	int orderId=0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY,Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getRestaurantId());
            pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            pstmt.setDouble(4, order.getTotalAmount());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getPaymentMethod());
            pstmt.setString(7,order.getPaymentId());
            pstmt.setString(8,order.getPaymentStatus());
            
            
            
            pstmt.executeUpdate();
            
            ResultSet res=pstmt.getGeneratedKeys();
            if(res.next()) {
            	orderId=res.getInt(1);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId;
    }
    

    @Override
    public Order getOrder(int orderId) {
        Order order = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY)) {

            pstmt.setInt(1, orderId);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                int userId = res.getInt("userId");
                int restaurantId = res.getInt("restaurantId");
                Timestamp orderDate = res.getTimestamp("orderDate");
                double totalAmount = res.getDouble("totalAmount");
                String status = res.getString("status");
                String paymentMethod = res.getString("paymentMethod");
                String paymentId=res.getString("paymentId");
                String paymentStatus=res.getString("paymentStatus");
                int deliveryAgentId=res.getInt("deliveryAgentId");
                String deliveryStatus=res.getString("deliveryStatus");

                order = new Order(orderId,userId,restaurantId,orderDate,totalAmount,status,paymentMethod,paymentId,paymentStatus,deliveryAgentId,deliveryStatus);
            }

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
    
    @Override
    public void updateOrderStatus(int orderId, String status) {

        String sql =
        "UPDATE `order` SET status=? WHERE orderId=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, status);
            pstmt.setInt(2, orderId);

            pstmt.executeUpdate();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

            pstmt.setInt(1, orderId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public List<Order> getAllOrders() {

        List<Order> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet res = stmt.executeQuery(SELECT_ALL_QUERY)) {

            while (res.next()) {

                int orderId = res.getInt("orderId");
                int userId = res.getInt("userId");
                int restaurantId = res.getInt("restaurantId");
                Timestamp orderDate = res.getTimestamp("orderDate");
                double totalAmount = res.getDouble("totalAmount");
                String status = res.getString("status");
                String paymentMethod = res.getString("paymentMethod");
                String paymentId=res.getString("paymentId");
                String paymentStatus=res.getString("paymentStatus");
                int deliveryAgentId=res.getInt("deliveryAgentId");
                String deliveryStatus=res.getString("deliveryStatus");

                Order order = new Order(orderId,userId,restaurantId,orderDate,totalAmount, status,paymentMethod,paymentId,paymentStatus,deliveryAgentId,deliveryStatus);

                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<Order> getOrdersByUserId(int userId){

        List<Order> orders = new ArrayList<>();

        String sql = "SELECT * FROM `order` WHERE userId=? ORDER BY orderDate DESC";

        try {
        	Connection con = DBConnection.getConnection();
        	
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){

                Order order = new Order();

                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setRestaurantId(rs.getInt("restaurantId"));
                order.setOrderDate(rs.getTimestamp("orderDate"));
                order.setPaymentMethod(rs.getString("paymentMethod"));
                order.setStatus(rs.getString("status"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setPaymentId(rs.getString("paymentId"));
                order.setPaymentStatus(rs.getString("paymentStatus"));

                orders.add(order);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return orders;
    }
    
    @Override
    public int getOrderCount() {

        int count = 0;

        String sql = "SELECT COUNT(*) FROM `order`";

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
    
    public boolean assignDeliveryAgent(int orderId,int deliveryAgentId){

        String sql="UPDATE `order` SET deliveryAgentId=?,deliveryStatus='Accepted' WHERE orderId=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement pstmt=con.prepareStatement(sql)){

            pstmt.setInt(1,deliveryAgentId);
            pstmt.setInt(2,orderId);

//            return pstmt.executeUpdate()>0;
            int rows = pstmt.executeUpdate();

            System.out.println("Rows Updated = " + rows);

            return rows > 0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }
    
    public List<Order> getOrdersByDeliveryAgent(int deliveryAgentId){

        List<Order> orders = new ArrayList<>();

        String sql =
            "SELECT * FROM `order` WHERE deliveryAgentId=? AND deliveryStatus!='Delivered' ORDER BY orderDate DESC";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, deliveryAgentId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){

                Order order = new Order();

                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setRestaurantId(rs.getInt("restaurantId"));
                order.setOrderDate(rs.getTimestamp("orderDate"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setStatus(rs.getString("status"));
                order.setPaymentMethod(rs.getString("paymentMethod"));
                order.setPaymentStatus(rs.getString("paymentStatus"));
                order.setDeliveryAgentId(rs.getInt("deliveryAgentId"));
                order.setDeliveryStatus(rs.getString("deliveryStatus"));

                orders.add(order);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return orders;
    }
    
    public void updateDeliveryStatus(int orderId, String status){

        String sql =
        "UPDATE `order` SET deliveryStatus=? WHERE orderId=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, status);
            pstmt.setInt(2, orderId);

            pstmt.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<Order> getDeliveredOrders(int deliveryAgentId){

        List<Order> list = new ArrayList<>();

        String sql =
        "SELECT * FROM `order` " +
        "WHERE deliveryAgentId=? " +
        "AND deliveryStatus='Delivered' " +
        "ORDER BY orderDate DESC";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, deliveryAgentId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){

                Order order = new Order();

                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setRestaurantId(rs.getInt("restaurantId"));
                order.setOrderDate(rs.getTimestamp("orderDate"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setStatus(rs.getString("status"));
                order.setPaymentMethod(rs.getString("paymentMethod"));
                order.setPaymentStatus(rs.getString("paymentStatus"));
                order.setDeliveryAgentId(rs.getInt("deliveryAgentId"));
                order.setDeliveryStatus(rs.getString("deliveryStatus"));

                list.add(order);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
    
