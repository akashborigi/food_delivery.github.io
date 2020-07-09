package onlineFood;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.*;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = String.valueOf(request.getParameter("UserName"));
		String email = String.valueOf(request.getParameter("Email"));
		String pwd = String.valueOf(request.getParameter("password"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
			PreparedStatement ps =con.prepareStatement("insert into Customer values(?,?,?)");
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, pwd);
			
				int i = ps.executeUpdate();
				if(i>0)
				{
					response.sendRedirect("FOOD1.html");
				}
				out.println("please enter your Credentials again");
				con.close();
				ps.close();
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		out.close();
		
	}

}
