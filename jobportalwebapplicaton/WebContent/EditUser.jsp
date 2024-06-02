<%@page import="getter_setter.employe"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Database.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<style>

body {
            margin: 0; /* Set margin to 0 */
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f5f5; /* Set background color */
        }
        
        table {
            width: 80%;
            max-width: 800px;
            margin: 50px auto; /* Center table horizontally */
            background-color: #fff; /* Set table background color */
            border-collapse: collapse;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add shadow */
        }
        
        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd; /* Add border bottom for cells */
            text-align: left;
        }
        
        th {
            background-color: #007bff; /* Set header background color */
            color: #fff; /* Set header text color */
        }
        
        tr:nth-child(even) {
            background-color: #f2f2f2; /* Set even row background color */
        }
        
        tr:hover {
            background-color: #ddd; /* Set hover row background color */
        }
        
        a {
            color: #007bff; /* Set link color */
            text-decoration: none;
            margin-right: 10px;
        }
        
        a:hover {
            text-decoration: underline; /* Add underline on hover */
        }
</style>
</head>
<body>


<%
response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
String ses=(String)session.getAttribute("eidadmin");

try {
    if(ses==null) {
        RequestDispatcher rd=request.getRequestDispatcher("authadmin");
        rd.forward(request, response);
    }
} catch(NullPointerException e) {
    e.getMessage();
    response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
    RequestDispatcher rd=request.getRequestDispatcher("authadmin");
    rd.forward(request, response);
}
%>

<table>
    <thead>
        <tr>
            <th>Sr no.</th>
            <th>User name</th>
            <th>Email id</th>
            <th>Field</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <% 
        int counter = 1;
        DBhandler dao = new DBhandler();
        LinkedList<employe> list = dao.getemployes();
        
        for(employe objemp : list) {
        %>
        <tr>
            <td><%=counter++ %></td>
            <td><%=objemp.getStrEname() %></td>
            <td><%=objemp.getStrEid() %></td>
            <td><%=objemp.getStrsec() %></td>
            <td><a href="UpdateUser.jsp?srno1=<%=objemp.getStrempno() %>">Edit</a></td>
            <td><a href="removeUser?srno=<%=objemp.getStrempno() %>">Delete</a></td>
        </tr>
        <%
        }
        %>
    </tbody>
</table>
</body>
</html>