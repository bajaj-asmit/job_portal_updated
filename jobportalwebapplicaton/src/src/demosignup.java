package src;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.DBhandler;

/**
 * Servlet implementation class demosignup
 */
@WebServlet("/demosignup")
public class demosignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demosignup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	  doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		DBhandler dao=new DBhandler();
		
		String strname=request.getParameter("nm");
	    String stremail=request.getParameter("email");
	    String strdao=request.getParameter("dob");
	    String strpass=request.getParameter("pass");
	    String strsec=request.getParameter("sector");
	    String strphn=request.getParameter("phnno");
	    
	    Random random = new Random();
        
        int randomNumber = random.nextInt(9000) + 1000;

        System.out.println("Random 4-digit number: " + randomNumber);
        System.out.println("my otp="+randomNumber);
       
        HttpSession session = request.getSession();
        String[] signupdata= {strname,stremail,strdao,strpass,strsec,strphn};
        session.setAttribute("signupdata", signupdata);
        
        session.setAttribute("otp", randomNumber);
        //dao.insertintodemoemploye(strname, stremail, strpass, strdao, strsec, strphn);
        
       // getServletContext().setAttribute("otp", randomNumber);
	    response.sendRedirect("otp.jsp");
	}

}
