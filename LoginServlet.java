package onlineFood;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.*;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = String.valueOf(request.getParameter("UserName"));
		String pwd = String.valueOf(request.getParameter("password"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
			PreparedStatement ps =con.prepareStatement("select C_NAME,C_PASS from Customer where C_NAME=? and C_PASS=?");
				ps.setString(1, name);
				ps.setString(2, pwd);
			
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					out.print("Login Sucessfully");
					RequestDispatcher rd=request.getRequestDispatcher("FOOD3.jsp");  
			        rd.forward(request, response);  
				}
				out.println("Invalid Credentials");
				con.close();
				ps.close();
				rs.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		out.close();
	}

}
