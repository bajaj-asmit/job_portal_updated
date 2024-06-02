<%@page import="getter_setter.jobs"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Database.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Jobs</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background: linear-gradient(120deg, #2980b9, #3498db);
            font-family: Arial, sans-serif;
        }

        .table {
            width: 100%;
            background-color: rgba(255, 255, 255, 0.9);
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
            margin-top: 50px;
        }

        .table-header {
            background-color: #2980b9;
            color: white;
            padding: 20px;
            font-weight: bold;
            text-align: center;
        }

        .table-body {
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table td, table th {
            padding: 10px;
            text-align: center;
            font-size: 16px;
            border-bottom: 1px solid #ddd;
        }

        table tr:hover {
            background-color: #f2f2f2;
        }

        .anchor {
            text-decoration: none;
            color: #fff;
            background-color: #2980b9;
            padding: 8px 15px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .anchor:hover {
            background-color: #3498db;
        }
    </style>
</head>
<body>

<main class="table">
    <section class="table-header">
        <h1>Jobs</h1>
    </section>
    <section class="table-body">
        <table>
            <thead>
            <tr>
                <th>Sr No</th>
                <th>Company Name</th>
                <th>Job Requirement</th>
                <th>Work Experience</th>
                <th>Field</th>
                <th>Designation</th>
                <th>Vacancies</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <% 
                DBhandler dao=new DBhandler();
                LinkedList<jobs> list=dao.getjobs();
                int count=1;
                for(jobs objjob:list)
                {
            %>
            <tr>
                <td><%=count++ %></td>
                <td><%=objjob.getStrCnm() %>
                <td><%=objjob.getStrjobreq() %></td>
                <td><%=objjob.getStrwrkexp() %></td>
                <td><%=objjob.getStrfild() %></td>
                <td><%=objjob.getStrdesi() %></td>
                <td><%=objjob.getStrvaccy() %></td>
                <td><button  class="btn btn-primary" onclick="alert('Login first');">Apply here</button></td>
            </tr>
            <% 
                }
            %>
            </tbody>
        </table>
    </section>
</main>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
