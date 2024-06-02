package src;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DBhandler;

/**
 * Servlet implementation class rejectuser
 */
@WebServlet("/rejectuser")
public class rejectuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public rejectuser() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out=response.getWriter();
		
		int empserialnumber = Integer.parseInt(request.getParameter("empsrno"));
		
		DBhandler dao= new DBhandler();
		
		String name=dao.getUserNameBySerialNumber(empserialnumber);
		String number=dao.getContactNumberBySerialNumber(empserialnumber);
		
		int jobserialnumber=dao.getJobSerialNumberByEmpSerialNumber(empserialnumber);
		
		String companyname=dao.getCompanynamebyjobserialnumber(jobserialnumber);
		String jobtitle=dao.getJobTitlebyjobserialnumber(jobserialnumber);
		
		
		String message="Hey, "+name+" thank you to apply in "+companyname+" for "+jobtitle+" post unfortunationally your application is not selected for next round thank you for giving your precious time ";
		
		System.out.println(number+" "+message);
		
		dao.deleteuserfromappliedjob(empserialnumber,jobserialnumber);

		SendSms.sendSms(message, number);
		out.println("<script>alert('Message sent successfully'); window.location.href = 'AppliedJobs.jsp';</script>");


		
//		doGet(request, response);
	}

}
