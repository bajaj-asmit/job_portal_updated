<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="getter_setter.employe"%>
<%@page import="Database.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User portal</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<style>body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-image: url('userbackground.jpg');
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
}

nav {
    background-color: rgba(0, 0, 0, 0.7);
    color: #fff;
    padding: 10px 20px;
}

nav ul {
    list-style: none;
    margin: 0;
    padding: 0;
    display: flex;
    align-items: center;
    justify-content: flex-end;
}

nav ul li {
    margin-left: 20px;
}

nav ul li:first-child {
    margin-left: 0;
}

nav ul li a {
    text-decoration: none;
    color: #fff;
    font-weight: bold;
    transition: color 0.3s;
}

nav ul li a:hover {
    color: #ffcc00;
}

.profile-icon {
    margin-right: 10px;
}
footer {
    background-color: #333;
    color: #fff;
    height: 65px; /* Set the height of the footer */
    text-align: center;
    position: fixed;
    bottom: 0;
    width: 100%;
    z-index: 100;
}

.footer-content {
    margin-bottom: 10px; /* Adjust margin for spacing */
}

.footer-info h3 {
    margin-bottom: 5px;
}

.footer-info p {
    margin: 3px 0;
}

.footer-bottom {
    margin-top: 10px; /* Adjust margin for spacing */
}

</style>
</head>
<body>
  
  <%
response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
  String ses=(String)session.getAttribute("eid");
  
  try {
		
	  if(ses==(null))
	  {
	  	RequestDispatcher rd=request.getRequestDispatcher("authEmploye");
	  	   rd.forward(request, response);
	  

	  }
	  else
	  {
	  
	 // out.println("session is not expierd current user "+ses);
	  
	  }
	  }
	  catch(NullPointerException e)
	  {
	     e.getMessage();
	     response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
	     RequestDispatcher rd=request.getRequestDispatcher("authEmploye");
	     rd.forward(request, response);
	  }
	  %>

  
 
  
  <nav>
  
  
  <%
 
  
  
  DBhandler dao=new DBhandler();
  //out.println(ses);
  LinkedList<employe> objlist=dao.getEmployesbyEmpemail(ses);
  
  for(employe objemp:objlist)
  {
	  
	  HttpSession session3=request.getSession();
	  session3.setAttribute("field", objemp.getStrsec());
	
  }
  
  %> 
   <li>
    <%=ses %>  <i style="float:left" class="fas fa-user-circle fa-lg profile-icon"></i> <!-- Profile icon -->
    </li>
  
   <ul>
  
    <li><a href="#">Home Page</a></li>
    <li><a href="passwordchange.html">Change Password</a></li>
    <% 
    boolean res=dao.isProfileUpdated(ses);
    
    if(res==false)
    {
    %>
    <li><a href="updateProfile.jsp">Update Profile</a></li>
    <%
    }%>
    <li><a href="empjobs.jsp">Jobs</a></li>
    <li><a href="LogOutEmp">Logout</a></li>
  </ul>
 </nav>
 
<footer>
    <div class="footer-content">
        <div class="footer-info">
            <h3>Contact Us</h3>
            <p>Email: info@jobportal.com</p>
            <p>Phone: +1-123-456-7890</p>
            <p>Address: 123 Job Street, City, Country</p>
        </div>
    </div>
    <div class="footer-bottom">
        <p>&copy; 2024 Job Portal. All rights reserved.</p>
    </div>
</footer>

 
</body>
</html> 