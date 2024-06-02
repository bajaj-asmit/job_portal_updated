<%@page import="getter_setter.jobs"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Database.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit job</title>
<style>

body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f5f5; /* Set background color */
        }
        
        form {
            width: 80%;
            max-width: 600px;
            margin: 50px auto; /* Center form horizontally */
            background-color: #fff; /* Set form background color */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add shadow */
        }
        
        label {
            font-weight: bold;
        }
        
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        
        input[type="submit"] {
            background-color: #007bff; /* Button background color */
            color: #fff; /* Button text color */
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s; /* Smooth transition */
        }
        
        input[type="submit"]:hover {
            background-color: #0056b3; /* Button hover background color */
        }

</style>
</head>
<body>
<%
DBhandler dao=new DBhandler();
//String strsessionfield=(String)session.getAttribute("field");
int srno= Integer.parseInt( request.getParameter("srno1") );
LinkedList<jobs> list=dao.getjobsBySrno(srno);
%>
    
<form action="editjob" method="post">
    <%
    for (jobs j : list) {
    %>
    <input type="hidden" name="srnumber" value="<%= srno %>">
    
    <label for="companyName">Company Name:</label>
    <input type="text" id="companyName" name="companyName" value="<%= j.getStrCnm() %>">
    
    <label for="jobTitle">Job Title:</label>
    <input type="text" id="jobTitle" name="jobTitle" value="<%= j.getStrjobreq() %>">
    
    <label for="workExperience">Work Experience:</label>
    <input type="text" id="workExperience" name="workExperience" value="<%= j.getStrwrkexp() %>">
    
    <label for="post">Post:</label>
    <input type="text" id="post" name="post" value="<%= j.getStrfild() %>">
    
    <label for="location">Location:</label>
    <input type="text" id="location" name="location" value="<%= j.getStrdesi() %>">
    
    <label for="vacancy">Vacancy:</label>
    <input type="number" id="vacancy" name="vacancy" value="<%= j.getStrvaccy() %>">
    <%
    }
    %>
    <input type="submit" value="Submit">
</form>
</body>

</html>