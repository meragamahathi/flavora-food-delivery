package com.food.servlet;

import java.io.IOException;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createOrder")
public class CreateOrderServlet extends HttpServlet {

    // Replace with your own Test Key ID and Test Key Secret
    private static final String KEY_ID = "rzp_test_TEGSzLIlJklQwS";
    private static final String KEY_SECRET = "9EwYyF46rKWQjQm36VS2yh2x";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
        	
        	System.out.println("========== CreateOrderServlet Called ==========");

            String amountStr = request.getParameter("amount");
            System.out.println("Amount Received : " + amountStr);

            // Amount comes from payment.js in paise
            int amount = Integer.parseInt(request.getParameter("amount"));

            RazorpayClient razorpay = new RazorpayClient(KEY_ID, KEY_SECRET);

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount);
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "receipt_" + System.currentTimeMillis());
            
            System.out.println("Creating Razorpay Order...");


            Order order = razorpay.orders.create(orderRequest);
            
            System.out.println("Razorpay Order Created Successfully");
            System.out.println(order.toString());

            response.setContentType("application/json");
            response.getWriter().write(order.toString());

        } catch (Exception e) {

            e.printStackTrace();

            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

            JSONObject error = new JSONObject();
            error.put("error", "Unable to create Razorpay Order");

            response.getWriter().write(error.toString());
        }
    }
}
