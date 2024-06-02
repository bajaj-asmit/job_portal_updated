<%@page import="getter_setter.linkendin"%>
<%@page import="getter_setter.employe"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Database.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<style>
    .profile-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    .profile-icon {
        text-align: center;
    }

    .profile-image {
        width: 150px; /* Adjust the size of the profile icon as needed */
        height: 150px; /* Adjust the size of the profile icon as needed */
    }

    .profile-details {
        text-align: center;
        margin-top: 20px;
    }

    .profile-details input,
    .profile-details button {
        margin-bottom: 10px;
        padding: 5px;
        width: 200px;
        box-sizing: border-box;
    }

    #shortlist-btn,
    #reject-btn {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
    }

    #reject-btn {
        background-color: #FF5733; /* Change color as needed */
    }
</style>
</head>
<body>
<%
int empserialnumber= Integer.parseInt(  request.getParameter("empsrno")) ;

%>

    <div class="profile-container">
        <div class="profile-icon">
            <img src="profile-icon.png" alt="Profile Icon" class="profile-image">
        </div>
        <div class="profile-details">
        <%
        
        DBhandler dao=new DBhandler();
        
        LinkedList<employe> list1=dao.getempbySrno(empserialnumber);
        LinkedList<linkendin> list2=dao.getUserlinkedin(empserialnumber);
        for(employe emp:list1)
        {
        %>
            <input type="text" id="username" name="username" placeholder="Username" value="<%=emp.getStrEname() %>" readonly><br>
            <input type="text" id="phone" name="phone" placeholder="Phone Number" value="<%=emp.getStrEnum() %>" readonly><br>
            <input type="email" id="email" name="email" placeholder="Email ID" value="<%=emp.getStrEid() %>" readonly><br>
            <input type="text" id="sector" name="sector" placeholder="Sector" value="<%=emp.getStrsec() %>" readonly><br>
         <%
        }
         %>
         
         <%
         for(linkendin l1:list2)
         {
         %>
            <input type="text" id="linkedin" name="linkedin" placeholder="LinkedIn ID" value="<%=l1.getLinkedin() %>" readonly><br>
            <input type="text" id="skills" name="skills" placeholder="Skills" value="<%=l1.getSkills() %>" readonly><br>
            <input type="text" id="certificate" name="certificate" placeholder="Certificate" value="<%=l1.getCerificate() %>" readonly><br>
          <%
         }
          %>
           <a href="shortlistuser?empsrno=<%=empserialnumber %>" id="shortlist-btn">Shortlist</a>
           <a href="rejectuser?empsrno=<%=empserialnumber %>" id="reject-btn">Reject User</a>

        </div>
    </div>
</body>
</html>
