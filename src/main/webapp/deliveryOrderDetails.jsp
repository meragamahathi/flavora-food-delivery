<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.food.model.*"%>

<%
Order order=(Order)request.getAttribute("order");
User customer=(User)request.getAttribute("customer");
Restaurant restaurant=(Restaurant)request.getAttribute("restaurant");
List<OrderItem> items=(List<OrderItem>)request.getAttribute("items");

Map<Integer, Menu> menuMap =
(Map<Integer, Menu>)request.getAttribute("menuMap");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Delivery Order Details</title>

<link rel="stylesheet" href="css/deliveryOrderDetails.css">

</head>

<body>

<div class="container">

    <div class="top-bar">

        <a href="deliveryDashboard" class="back-btn">
            ← Back
        </a>

        <h1>Order #<%=order.getOrderId()%></h1>

        <span class="status">
            <%=order.getDeliveryStatus()%>
        </span>

    </div>


    <div class="grid">

        <!-- Restaurant Card -->

        <div class="card">

            <h2>🍴 Restaurant</h2>

            <img src="images/<%=restaurant.getImageUrl()%>" class="restaurant-img">

            <h3><%=restaurant.getName()%></h3>

            <p><%=restaurant.getAddress()%></p>

        </div>


        <!-- Customer Card -->

        <div class="card">

            <h2>👤 Customer</h2>

            <h3><%=customer.getUserName()%></h3>

            <p><%=customer.getEmail()%></p>

            <p><%=customer.getAddress()%></p>

        </div>

    </div>


    <!-- Ordered Items -->

    <div class="card">

        <h2>Ordered Items</h2>

        <table>

            <tr>

                <th>Image</th>
                <th>Item</th>
                <th>Qty</th>
                <th>Total</th>

            </tr>

            <%
            for(OrderItem item : items){

                Menu menu = menuMap.get(item.getMenuId());
            %>

            <tr>

                <td>

                    <img src="images/<%=menu.getImageUrl()%>" class="food-img">

                </td>

                <td>

                    <%=menu.getItemName()%>

                </td>

                <td>

                    <%=item.getQuantity()%>

                </td>

                <td>

                    ₹ <%=item.getItemTotal()%>

                </td>

            </tr>

            <%
            }
            %>

        </table>

    </div>


    <!-- Payment -->

    <div class="card">

        <h2>Payment Summary</h2>

        <p>

            Payment Method :
            <b><%=order.getPaymentMethod()%></b>

        </p>

        <p>

            Payment Status :
            <b><%=order.getPaymentStatus()%></b>

        </p>

        <h3>

            Total :
            ₹ <%=order.getTotalAmount()%>

        </h3>

    </div>


    <!-- Timeline -->

    <div class="card">

        <h2>Delivery Progress</h2>

        <%
String deliveryStatus = order.getDeliveryStatus();

boolean accepted = false;
boolean picked = false;
boolean outForDelivery = false;
boolean delivered = false;

if(deliveryStatus.equalsIgnoreCase("Accepted")){
    accepted = true;
}
else if(deliveryStatus.equalsIgnoreCase("Picked Up")){
    accepted = true;
    picked = true;
}
else if(deliveryStatus.equalsIgnoreCase("Out For Delivery")){
    accepted = true;
    picked = true;
    outForDelivery = true;
}
else if(deliveryStatus.equalsIgnoreCase("Delivered")){
    accepted = true;
    picked = true;
    outForDelivery = true;
    delivered = true;
}
%>

<div class="timeline">

    <div class="step <%=accepted?"active":""%>">
        Accepted
    </div>

    <div class="step <%=picked?"active":""%>">
        Picked Up
    </div>

    <div class="step <%=outForDelivery?"active":""%>">
        Out For Delivery
    </div>

    <div class="step <%=delivered?"active":""%>">
        Delivered
    </div>

</div>

    </div>
 
     <!-- Status Buttons -->

<div class="card">

    <h2>Update Status</h2>

    <%
    String status = order.getDeliveryStatus();

    if(status.equalsIgnoreCase("Accepted")){
    %>

        <form action="updateDeliveryStatus" method="post">

            <input type="hidden"
                   name="orderId"
                   value="<%=order.getOrderId()%>">

            <button type="submit"
                    name="status"
                    value="Picked Up"
                    class="action-btn">

                Pick Up Order

            </button>

        </form>

    <%
    }
    else if(status.equalsIgnoreCase("Picked Up")){
    %>

        <form action="updateDeliveryStatus" method="post">

            <input type="hidden"
                   name="orderId"
                   value="<%=order.getOrderId()%>">

            <button type="submit"
                    name="status"
                    value="Out For Delivery"
                    class="action-btn">

                Start Delivery

            </button>

        </form>

    <%
    }
    else if(status.equalsIgnoreCase("Out For Delivery")){
    %>

        <form action="updateDeliveryStatus" method="post">

            <input type="hidden"
                   name="orderId"
                   value="<%=order.getOrderId()%>">

            <button type="submit"
                    name="status"
                    value="Delivered"
                    class="action-btn">

                Mark Delivered

            </button>

        </form>

    <%
    }
    else if(status.equalsIgnoreCase("Delivered")){
    %>

        <h2 style="color:green;">
            ✅ Order Delivered Successfully
        </h2>

    <%
    }
    %>

</div>
</div>

</body>

</html>