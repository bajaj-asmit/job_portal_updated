<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Portal</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
      body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-image: url('adminback.jpg');
           background-size: 100% auto; 
            background-position: center; 
            background-size: cover;
            background-repeat: repeat;
        }

        .navbar {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
        }

        .navbar ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: flex-end;
        }

        .navbar ul li {
            margin-left: 20px;
        }

        .navbar ul li:first-child {
            margin-left: 0;
        }

        .navbar ul li a {
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            transition: color 0.3s;
        }

        .navbar ul li a:hover {
            color: #ffcc00;
        }

        .admin-icon {
            margin-right: 10px;
        }

        .footer {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
            height: 65px;
            width: 100%;
            position: fixed;
            bottom: 0;
            left: 0;
        }

        .footer a {
            color: #fff;
            text-decoration: none;
        }    </style>
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
<div class="navbar">
    <span class="admin-icon">
        <i class="fas fa-user-shield"></i>
    </span>
    <ul>
        <li><a href="#">Home</a></li>
        <li><a href="adminpasswordchange.jsp">Change Password</a></li>
        <li><a href="addjobs.jsp">Add Jobs</a></li>
        <li><a href="Editjobs.jsp">Edit Jobs</a></li>
        <li><a href="EditUser.jsp">Edit User</a></li>
        <li><a href="AppliedJobs.jsp">Applied Jobs</a></li>
        <li><a href="logOutadmin">Logout</a></li>
    </ul>
</div>


<!-- Footer -->
<div class="footer">
    <p>&copy; 2024 Job Portal. All rights reserved. | <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a></p>
</div></body>
</html>
