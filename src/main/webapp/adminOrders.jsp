<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="com.food.model.Order" %>
<%@ page import="com.food.model.User" %>

<%
List<Order> orders = (List<Order>)request.getAttribute("orders");
List<User> agents = (List<User>)request.getAttribute("agents");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Manage Orders</title>

<link rel="stylesheet" href="css/adminOrders.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

</head>

<body>

<div class="container">

    <div class="sidebar">

        <h2>🍴 FLAVORA</h2>

        <ul>

            <li><a href="adminDashboard">Dashboard</a></li>

            <li><a href="adminUsers">Users</a></li>

            <li><a href="adminRestaurants">Restaurants</a></li>

            <li><a href="adminMenus">Menu</a></li>

            <li class="active">Orders</li>

            <li><a href="logout">Logout</a></li>

        </ul>

    </div>


    <div class="content">

        <h1>Manage Orders</h1>

        <table>

            <thead>

            <tr>

                <th>Order ID</th>
                <th>User ID</th>
                <th>Restaurant ID</th>
                <th>Date</th>
                <th>Amount</th>
                <th>Payment</th>
                <th>Payment Status</th>
                <th>Status</th>
                <th>Delivery Agent</th>
                <th>Action</th>

            </tr>

            </thead>

            <tbody>

            <%
            for(Order order : orders){
            %>

            <tr>

                <td><%=order.getOrderId()%></td>

                <td><%=order.getUserId()%></td>

                <td><%=order.getRestaurantId()%></td>

                <td>

                <%=new java.text.SimpleDateFormat("dd MMM yyyy")
                .format(order.getOrderDate())%>

                </td>

                <td>₹ <%=order.getTotalAmount()%></td>

                <td><%=order.getPaymentMethod()%></td>

                <td><%=order.getPaymentStatus()%></td>

                <td><%=order.getStatus()%></td>
                
                <td>

<%
if(order.getDeliveryAgentId() == 0){
%>

<form action="assignDelivery" method="post">

    <input type="hidden"
           name="orderId"
           value="<%=order.getOrderId()%>">

    <select name="deliveryAgentId" class="agent-select" required>

        <option value="">Select Agent</option>

        <%
        if(agents != null){
            for(User agent : agents){
        %>

        <option value="<%=agent.getUserId()%>">
            <%=agent.getUserName()%>
        </option>

        <%
            }
        }
        %>

    </select>

    <button type="submit" class="assign-btn">
        Assign
    </button>

</form>

<%
}else{
%>

<%
User assignedAgent = null;

for(User agent : agents){
    if(agent.getUserId() == order.getDeliveryAgentId()){
        assignedAgent = agent;
        break;
    }
}
%>


<%= assignedAgent != null ? assignedAgent.getUserName() : "Unknown Agent" %>

<%
}
%>

</td>

                <td>

                    <form action="updateOrderStatus"
                          method="post"
                          class="action-form">

                        <input type="hidden"
                               name="orderId"
                               value="<%=order.getOrderId()%>">

                        <select name="status" class="status-select">

                            <option value="Pending"
                            <%=order.getStatus().equals("Pending")?"selected":""%>>
                            Pending
                            </option>

                            <option value="Preparing"
                            <%=order.getStatus().equals("Preparing")?"selected":""%>>
                            Preparing
                            </option>

                            <option value="Out For Delivery"
                            <%=order.getStatus().equals("Out For Delivery")?"selected":""%>>
                            Out For Delivery
                            </option>

                            <option value="Delivered"
                            <%=order.getStatus().equals("Delivered")?"selected":""%>>
                            Delivered
                            </option>

                            <option value="Cancelled"
                            <%=order.getStatus().equals("Cancelled")?"selected":""%>>
                            Cancelled
                            </option>

                        </select>

                         <button type="submit" class="update-btn">
                            Update
                         </button>

                    </form>

                </td>

            </tr>

            <%
            }
            %>

            </tbody>

        </table>

    </div>

</div>

</body>
</html>