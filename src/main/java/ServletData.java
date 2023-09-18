

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletData
 */
@WebServlet("/ServletData")
public class ServletData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletData() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String college=request.getParameter("college");
		String city=request.getParameter("city");
		String mob=request.getParameter("mobno");
		String gen=request.getParameter("gender");
		String course=request.getParameter("course");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/suhas","root","root");
			String sql="INSERT into register(name,college,city,mob,gender,course)VALUES(?,?,?,?,?,?);";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, college);
			ps.setString(3, city);
			ps.setString(4, mob);
			ps.setString(5,gen);
			ps.setString(6, course);
			int c=ps.executeUpdate();
			if(c>0) {
				//out.print("<h1>Sucess</h1>");
				response.sendRedirect("success.html");
			}else {
				out.print("<h1>You have wrong</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("basicdetails.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			out.print("<h1>Error</h1>");
		}
	}

}
