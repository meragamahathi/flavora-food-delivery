package com.food.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import com.food.daoimpl.OrderDAOImpl;
import com.food.daoimpl.OrderItemDAOImpl;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.OrderItem;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/orderServlet")
public class CheckoutServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		Cart cart=(Cart)session.getAttribute("cart");
	    int restaurantId=(int)session.getAttribute("restaurantId");
		double totalAmount=(Double)session.getAttribute("totalAmount");

		
		String payment=req.getParameter("payment");
		String razorpayPaymentId = req.getParameter("razorpay_payment_id");
		String razorpayOrderId = req.getParameter("razorpay_order_id");
		String razorpaySignature = req.getParameter("razorpay_signature");
		// If Online Payment is selected
		if (!payment.equalsIgnoreCase("Cash on Delivery")) {

		    // Payment failed or popup closed
		    if (razorpayPaymentId == null || razorpayPaymentId.isEmpty()) {

		        resp.sendRedirect("paymentFailed.jsp");
		        return;
		    }

		    // Payment Success
		    System.out.println("Payment Successful");
		    System.out.println("Payment ID : " + razorpayPaymentId);
		    System.out.println("Order ID   : " + razorpayOrderId);
		}
		if(user==null) {

		    session.setAttribute("loginFrom", "checkout");

		    resp.sendRedirect("login.html");
		    return;
		}
		if(user!=null && cart!=null && !cart.getItems().isEmpty()) {
			
			Order order=new Order();
			
			order.setUserId(user.getUserId());
			order.setRestaurantId(restaurantId);
			order.setOrderDate(new Timestamp(System.currentTimeMillis()));
			order.setPaymentMethod(payment);
     		order.setStatus("pending");
			order.setPaymentId(razorpayPaymentId);
			
			if(payment.equalsIgnoreCase("Cash on Delivery")){
			    order.setPaymentStatus("Pending");
			}
			else{
			    order.setPaymentStatus("Paid");
			}
			
			order.setTotalAmount(totalAmount);
			
			OrderDAOImpl orderDAOImpl=new OrderDAOImpl();
			
			System.out.println("User ID: " + user.getUserId());
			System.out.println("Restaurant ID: " + restaurantId);
			System.out.println("Total Amount: " + totalAmount);
			System.out.println("Payment: " + payment);
			
			int orderId=orderDAOImpl.addOrder(order);
			System.out.println("Generated Order ID: " + orderId);
		
			OrderItemDAOImpl orderItemDAOImpl=new OrderItemDAOImpl();
			
			
			for(CartItem item:cart.getItems().values()) {
				
				OrderItem orderItem = new OrderItem();

				orderItem.setOrderId(orderId);
				orderItem.setMenuId(item.getMenuId());
				orderItem.setQuantity(item.getQuantity());
				orderItem.setItemTotal(item.getTotalPrice());
				orderItemDAOImpl.addOrderItem(orderItem);
				
				
				
			}
			
			session.removeAttribute("cart");
			session.removeAttribute("restaurantId");
			session.removeAttribute("totalAmount");
			
			resp.sendRedirect("orderConfirmation.jsp");
			
			
			
		}
		else {
			resp.sendRedirect("cart.jsp");
		}
		
		
	
	}

}
