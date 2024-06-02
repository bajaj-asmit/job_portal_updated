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
import javax.websocket.Session;

import Database.DBhandler;
import getter_setter.employe;

/**
 * Servlet implementation class changepass
 */
@WebServlet("/changepass")
public class changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepass() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 String stroldpass=request.getParameter("oldpass");
                 String strnewpass=request.getParameter("newpass");
                 DBhandler dao=new DBhandler();
                 HttpSession session=request.getSession(false);
                 String ses=(String) session.getAttribute("eid");
                 System.out.println(ses);
                 LinkedList<employe> listemp=dao.getEmployesbyEmpemail(ses);
                 PrintWriter out=response.getWriter();
                 System.out.println(listemp);
                 for(employe emp:listemp)
                 {
                 if(stroldpass.equals(emp.getStrpass()))
                 {
                	 System.out.println(emp.getStrempno()+" hello");
                	 dao.updatePass(emp.getStrempno(), strnewpass);
                	 out.println("<script> alert('password change successfully'); window.location.href = 'empPage.jsp'; </script>");
                 }
                 else {
					System.out.println("password incorrect");
					System.out.println(emp.getStrpass()+"hello 1");
					 out.println("<script> alert('old password incorct') </script>");
					System.out.println(strnewpass +"hello 2");
				}
                 }
	}

}
