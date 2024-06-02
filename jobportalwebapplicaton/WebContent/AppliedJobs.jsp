<%@page import="getter_setter.AppliedJobs"%>
<%@page import="getter_setter.jobs"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Database.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applied Jobs</title>
</head>
<style>

body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f5f5;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }

</style>
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
        <th>Phone number</th>
        <th>Job title</th>
        <th>Company name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <% 
    int counter=1;
    DBhandler dao=new DBhandler();
    LinkedList<AppliedJobs> list=dao.getapplyjobs();
    for(AppliedJobs obj:list) { %>
        <tr>
            <td><%=counter++ %></td>
            <td><%=obj.getUsername() %></td>
            <td><%=obj.getEmail() %></td>
            <td><%=obj.getPhonenumber() %></td>
            <td><%=obj.getJobtitle() %></td>
            <td><%=obj.getCompanyname() %></td>
            <td><a href="ViewProfile.jsp?empsrno=<%=obj.getEmpsrno() %>">View Profile</a></td>
        </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>