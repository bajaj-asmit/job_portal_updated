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
 * Servlet implementation class editjob
 */
@WebServlet("/editjob")
public class editjob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editjob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int srno= Integer.parseInt(request.getParameter("srnumber"));
		String companyname=request.getParameter("companyName");
		String jobtitle=request.getParameter("jobTitle");
		String workexperience=request.getParameter("workExperience");
		String post=request.getParameter("post");
		String location=request.getParameter("location");
		String vacancy=request.getParameter("vacancy");
		PrintWriter out=response.getWriter();
		DBhandler dao=new DBhandler();
		
		if(companyname != null && jobtitle!=null && workexperience!=null && post!=null && location!=null && vacancy!=null)
		{
			dao.updatejobs(srno, companyname, jobtitle, workexperience, post, location, vacancy);
			out.println("<script>alert('updated successfully'); window.location.href='Editjobs.jsp';</script>");
		}
		
		else
		{
			out.println("<script>alert('Please enter valid data in input'); window.location.href='Editjb.jsp';</script>");
		}
		
		
	}

}
