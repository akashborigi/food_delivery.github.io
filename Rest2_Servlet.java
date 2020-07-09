package onlineFood;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.*;
/**
 * Servlet implementation class Rest2_Servlet
 */
@WebServlet("/Rest2_Servlet")
public class Rest2_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rest2_Servlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = String.valueOf(request.getParameter("getchilled"));
		System.out.println(name);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
			PreparedStatement ps =con.prepareStatement("select * from getchilled where d_name=?");
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
            {
				  String str = rs.getString(1);
		          int i = rs.getInt(2);
		          request.setAttribute("str", str);
		          request.setAttribute("i", i);
		          RequestDispatcher rd=request.getRequestDispatcher("YUMM.jsp");  
			      rd.forward(request, response);
            }
				con.close();
				ps.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		out.close();
		
	}

}
