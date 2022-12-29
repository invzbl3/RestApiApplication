<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
         import="java.util.*,com.test.application.data.models.*"%>
<%@ page import="com.test.application.data.models.Project" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="../../includes/head.jsp"%>
</head>
<body style="background-color: #f8f9fa !important;">
<%@include file="../../includes/header.jsp"%>
<main role="main" class="container"> <%@include file="../../includes/msg.jsp"%>
    <div class="card">
        <div class="card-header text-white shadow bg-dark">
            <h2 class="float-left">Project Report</h2>
        </div>
        <div class="card-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Amount</th>
                </tr>
                </thead>
                <tbody>
                <%
                    float sumAmu = 0;
                    List<Project> projects = (List<Project>) request.getAttribute("pList");
                    for (Project p : projects)
                    {
                %>
                <tr>
                    <th scope="row"><%=p.getProjectId()%></th>
                    <td><%=p.getProjectName()%></td>
                    <td>Rs. <%= p.getProjectPrice() %></td>
                    <%
                        int sumQty = 0;
                        for(OrderProject op: p.getOrderProject()) {
                            if(!op.getOrder().getStatus().equals("CANCEL") && !op.getOrder().getStatus().equals("REJECT")) {
                                sumQty = sumQty + op.getBuyqty();
                            }
                        }
                    %>
                    <td><%= sumQty %></td>
                    <td>Rs. <%= sumQty * p.getProjectPrice() %></td>
                </tr>
                <%
                        sumAmu = sumAmu + sumQty * p.getProjectPrice();
                    }
                %>
                <tr><td  colspan="4" class="text-center"><b>Total Amount</b></td><td>Rs. <%= sumAmu %></td></tr>
                </tbody>
            </table>
        </div>
    </div>
    <br><br><br>
</main>
<%@include file="../../includes/footer.jsp"%>
</body>
</html>