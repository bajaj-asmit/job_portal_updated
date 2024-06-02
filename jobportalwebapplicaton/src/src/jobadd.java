package src;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Database.DBhandler;

@WebServlet("/jobadd")

public class jobadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public jobadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DBhandler dao=new DBhandler();
		int srno=dao.getMaxSrno();
		String strcnm=request.getParameter("companyName");
		String strjreq=request.getParameter("jobRequirements");
		String strwrkexp=request.getParameter("workExperience");
		String strfield=request.getParameter("field");
		String strdesi=request.getParameter("location");
		String strvaca=request.getParameter("vacancies");
		srno++;
		dao.insertIntoJobs(srno, strcnm, strjreq, strwrkexp, strfield, strdesi, strvaca);
		PrintWriter out=response.getWriter();
		out.println("<script>alert('job add successfully'); window.location.href ='admin.jsp'</script>");
		System.out.println("insert successfully");
	}

}
