package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Database.DBhandler;
import getter_setter.employe;

@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public signup() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    DBhandler dao=new DBhandler();
     int num=dao.getmaxEmpno();
     System.out.println("num in signup"+num);
     num=num+1;
	String strname=request.getParameter("nm");
    String stremail=request.getParameter("email");
    String strdao=request.getParameter("dob");
    String strpass=request.getParameter("pass");
    String strsec=request.getParameter("sector");
    String strphn=request.getParameter("phnno");
    System.out.println("new num "+num);
//    String userotp=request.getParameter("otp");
  // System.out.println(strname+" "+stremail);
//   HttpSession session=request.getSession(false);
//   String otp=(String) session.getAttribute("otp");

//    HttpSession session=request.getSession();
//    String otp=(String) session.getAttribute("otp");
//    System.out.println("this come from demosignup "+otp);
//    if(userotp.equals(otp))
//   {
//	   System.out.println("oh yess");
//   }
    PrintWriter out=response.getWriter();
    boolean phoneExist=dao.isUserphoneexist(strphn);
    boolean emailExist=dao.isUserEmailexist(stremail);
    if(emailExist==true && phoneExist==true)
    {
    	out.println("<script>alert('email and phone number already exist in database'); window.location.href = \"signup.html\";</script>");
    }
    else
    if(emailExist==true)
    {
    	out.println("<script>alert('email already exist in database'); window.location.href = \"signup.html\";</script>");
    }
    else
    if(phoneExist==true)
    {
    	out.println("<script>alert('phone number already exist in database'); window.location.href = \"signup.html\";</script>");
    }
    else
    {
    dao.userSignup(strname, stremail, strpass, strdao, strsec, strphn, num);
    }
    
    out.println("<script>alert('signup successfully'); window.location.href = \"login.html\";</script>");
    
	}

}
