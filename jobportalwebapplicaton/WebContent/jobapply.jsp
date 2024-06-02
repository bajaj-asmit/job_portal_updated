<%@page import="getter_setter.employe"%>
<%@page import="java.util.LinkedList"%>
<%@page import="getter_setter.jobs"%>
<%@page import="Database.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Application Form</title>
    <style type="text/css">
    
      body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .warning {
            color: red;
            font-weight: bold;
        }   
    </style>
</head>
<body>
<% String srnoStr = request.getParameter("srno");
int empserialnumber= Integer.parseInt( request.getParameter("empno"));
String ses=(String)session.getAttribute("eid");
int jobsrno = Integer.parseInt(srnoStr);
//out.println("empserial number"+empserialnumber);
//out.println("job serial number  "+jobsrno);
DBhandler dao=new DBhandler();
LinkedList<jobs> list = dao.getjobsBySrno(jobsrno);
LinkedList<employe> list2 =dao.getEmployesbyEmpemail(ses);

%>
   
<div class="container">
    <form action="applyjobs" method="post">
        <% 
        for(employe emp:list2) {
        %>      
            <input type="hidden" name="empserialnumber" value="<%=empserialnumber %>">
            <input type="hidden" name="jobsrno" value="<%= jobsrno %>">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" value="<%=emp.getStrEname() %>" readonly>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<%=emp.getStrEid() %>" readonly>
            </div>
            <div class="form-group">
                <label for="phone">Phone Number:</label>
                <input type="tel" id="phone" name="phone" value="<%=emp.getStrEnum() %>" readonly>
            </div>
        <% } %>

        <% 
        for(jobs objjob:list) {
        %>
            <div class="form-group">
                <label for="jobTitle">Job Title:</label>
                <input type="text" id="jobTitle" name="jobTitle" value="<%=objjob.getStrjobreq() %>" readonly>
            </div>
            <div class="form-group">
                <label for="company">Company Name:</label>
                <input type="text" id="company" name="company" value="<%=objjob.getStrCnm() %>" readonly>
            </div>
        <% } %>
 
      <%
      boolean res=dao.isProfileUpdated(ses);
      if(res==true)
      {
      %>
        <div class="form-group">
            <input type="submit" value="Apply">
        </div>
        <%
      }
      else
      {%>
    	  <div class="form-group">
        <span class="warning">You are not eligible now</span>
      </div>
      <%}
        %>
    </form>
    </div>
    </body>
</html>
