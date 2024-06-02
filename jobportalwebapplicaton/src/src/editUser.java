
package src;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DBhandler;

@WebServlet("/editUser")
public class editUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public editUser() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doPost(request, response);
	 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     int getsrno=Integer.parseInt(request.getParameter("srno"));
//     request.setAttribute("srno",getsrno );
//     RequestDispatcher rd=request.getRequestDispatcher("editUser.jsp");
//	  rd.forward(request, response);
		
		int srno = Integer.parseInt( request.getParameter("empno") );
		String username =request.getParameter("username");
		String email =request.getParameter("email");
		String phone =request.getParameter("phone");
		String sector =request.getParameter("sector");
		String dob =request.getParameter("dob");
		String password =request.getParameter("password");
		
		PrintWriter out=response.getWriter();
		DBhandler dao =new DBhandler();
//		if(username.equals("") && email.equals("") && phone.equals("") && sector.equals("") && dob.equals("") && password.equals(""))
//		{
//
//			out.println("<script>alert('Enter valid data'); window.location.href='UpdateUser.jsp' </script>");
//			
//		}
//		else
		
			dao.updateUserData(username, email, password, dob, sector, phone, srno);
			out.println("<script>alert('user updated successfully '); window.location.href='EditUser.jsp' </script>");
		
		
	}

}
