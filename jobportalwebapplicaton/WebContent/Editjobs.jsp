<%@page import="getter_setter.jobs"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Database.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit jobs</title>

 <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f5f5; /* Set background color */
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff; /* Set table background color */
        }
        
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        
        th {
            background-color: #007bff; /* Set header background color */
            color: white;
        }
        
        tr:nth-child(even) {
            background-color: #f2f2f2; /* Alternate row background color */
        }
        
        tr:hover {
            background-color: #ddd; /* Hover row background color */
        }
        
        a {
            text-decoration: none;
            color: #007bff; /* Link color */
        }
        
        a:hover {
            color: #0056b3; /* Hover link color */
        }
        
        @media screen and (max-width: 600px) {
            table {
                overflow-x: auto;
                display: block;
            }
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
            <th>Company Name</th>
            <th>Requirement</th>
            <th>Work Experience</th>
            <th>Field</th>
            <th>Location</th>
            <th>Vacancies</th>
            <th>Edit Job</th>
            <th>Delete Job</th>
        </tr>
    </thead>
    <tbody>
        <% 
        int counter = 1;
        DBhandler dao = new DBhandler();
        LinkedList<jobs> list = dao.getjobs();
        
        for (jobs objjob : list) {
        %>
        <tr>
            <td><%=counter++ %></td>
            <td><%=objjob.getStrCnm() %></td>
            <td><%=objjob.getStrjobreq() %></td>
            <td><%=objjob.getStrwrkexp() %></td>
            <td><%=objjob.getStrfild() %></td>
            <td><%=objjob.getStrdesi() %></td>
            <td><%=objjob.getStrvaccy()%></td>
            <td><a href="Editjb.jsp?srno1=<%=objjob.getSrno()%>">Edit Job</a></td>
            <td><a href="deleteJob?srno=<%=objjob.getSrno()%>">Delete Job</a></td>
        </tr>
        <%
        }
        %>
    </tbody>
</table>

</body>
</html>