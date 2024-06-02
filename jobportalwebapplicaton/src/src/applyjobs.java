package src;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Database.DBhandler;

/**
 * Servlet implementation class applyjobs
 */
@WebServlet("/applyjobs")
public class applyjobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public applyjobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int empserialnumber= Integer.parseInt( request.getParameter("empserialnumber") );
		int srno=Integer.parseInt( request.getParameter("jobsrno"));
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String jobtitle=request.getParameter("jobTitle");
		String companyName= request.getParameter("company");
		DBhandler dao =new DBhandler();
		String oldemail=dao.FetchEmailfromApplyjobs(srno);
		System.out.println("old email"+oldemail+" new "+email);
		if(oldemail.equals(email))
		{
    		out.println("<script> alert('you already apply in this job'); window.location.href = 'empjobs.jsp'; </script>");
			
		}
		else
		{
			dao.applyjob(srno, username, email, phone, jobtitle, companyName,empserialnumber);
		}
		
	    out.println("<script> alert('job apply successfuly successfully'); window.location.href = 'empPage.jsp'; </script>");
	}

}
