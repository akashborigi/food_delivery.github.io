package onlineFood;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.*;

/**
 * Servlet implementation class Rest4_Servlet
 */
@WebServlet("/Rest4_Servlet")
public class Rest4_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rest4_Servlet() {
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
		String name = String.valueOf(request.getParameter("tiffin"));
		System.out.println(name);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
			PreparedStatement ps =con.prepareStatement("select * from tiffin where t_name=?");
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
