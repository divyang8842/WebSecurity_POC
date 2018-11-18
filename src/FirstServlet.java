import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = -6346818772643975879L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("username");
		String p = request.getParameter("userpass");
		String type = request.getParameter("type");
		if(!"signup".equals(type)) {
			if (UserDao.validate(n, p)) {
				RequestDispatcher rd = request.getRequestDispatcher("servlet2");
				rd.forward(request, response);
			} else {
				out.print("Sorry username or password error");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
		}else {
			String f = request.getParameter("fname");
			String l = request.getParameter("lname");
			UserDao.insert_user_info(n, f, l, p);
			out.print("Signup Successfull.");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			request.removeAttribute("type");
			rd.include(request, response);
		}
		out.close();
	}

}
