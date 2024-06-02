<%@page import="getter_setter.employe"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Database.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>

<style>

body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f5f5;
        }

        .container {
            width: 80%;
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h2 {
            color: #007bff;
            text-align: center;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }

        input[type="text"],
        input[type="email"],
        input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

</style>

</head>
<body>
<%
int empno= Integer.parseInt(request.getParameter("srno1"));
DBhandler dao=new DBhandler();

LinkedList<employe> list=dao.getempbySrno(empno);
%>
<div class="container">
    <h2>Edit user</h2>
    <form action="editUser" method="post">
    <% for(employe emp:list) { %>
        <input type="hidden" name="empno" value="<%=emp.getStrempno() %>">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="<%=emp.getStrEname() %>">

        <label for="email">Email ID:</label>
        <input type="email" id="email" name="email" value="<%=emp.getStrEid() %>">

        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" value="<%=emp.getStrEnum() %>">

        <label for="sector">Sector:</label>
        <input type="text" id="sector" name="sector" value="<%=emp.getStrsec() %>">

        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" value="<%=emp.getStrdob() %>">

        <label for="password">Password:</label>
        <input type="text" id="password" name="password" value="<%=emp.getStrpass() %>">

    <% } %>
        <input type="submit" value="Update">
    </form>
</div>
</body>
</html>
