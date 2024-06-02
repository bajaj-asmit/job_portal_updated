<%@page import="getter_setter.jobs"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Database.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="style.css">
<style>

/* Set blue color theme */
body {
    background-color: #f0faff;
}

.container {
    margin-top: 20px;
    padding-bottom: 20px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.table {
    border-collapse: collapse;
    width: 100%;
}

.table th,
.table td {
    padding: 10px;
    text-align: center;
}

.table th {
    background-color: #007bff;
    color: #fff;
}

.table tbody tr:nth-child(even) {
    background-color: #f2f2f2;
}

.table tbody tr:hover {
    background-color: #cce5ff;
}

.apply-job-link {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007bff; /* Blue color */
    color: #fff;
    text-decoration: none;
    border-radius: 5px;
    transition: background-color 0.3s;
}

.apply-job-link:hover {
    background-color: #0056b3; 
}


</style>
</head>
<body>

<%
    response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
    String ses=(String)session.getAttribute("eid");
    try {
        if(ses==(null)) {
            RequestDispatcher rd=request.getRequestDispatcher("authEmploye");
            rd.forward(request, response);
        }
    } catch(NullPointerException e) {
        e.getMessage();
        response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
        RequestDispatcher rd=request.getRequestDispatcher("authEmploye");
        rd.forward(request, response);
    }
%>

<div class="container">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Sr no.</th>
                <th scope="col">Company name</th>
                <th scope="col">Requirement</th>
                <th scope="col">Work experience</th>
                <th scope="col">Field</th>
                <th scope="col">Location</th>
                <th scope="col">Vacancies</th>
                <th scope="col">Apply jobs</th>
            </tr>
        </thead>
        <tbody>
        <% 
            int counter=1;
            DBhandler dao=new DBhandler();
            String strsessionfield=(String)session.getAttribute("field");
            LinkedList<jobs> list=dao.getjobsbycategory(strsessionfield);
            int empno=dao.getcurrentempno(ses);
            for(jobs objjob:list) {
        %>
            <tr>
                <td><%=counter++ %></td>
                <td><%=objjob.getStrCnm() %></td>
                <td><%=objjob.getStrjobreq() %></td>
                <td><%=objjob.getStrwrkexp() %></td>
                <td><%=objjob.getStrfild() %></td>
                <td><%=objjob.getStrdesi() %></td>
                <td><%=objjob.getStrvaccy()%></td>
                <td><a href="jobapply.jsp?srno=<%=objjob.getSrno()%>&empno=<%= empno %>" class="apply-job-link">Apply job</a></td>
            </tr>
        <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
