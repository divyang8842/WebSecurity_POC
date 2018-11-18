import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1357482550088303185L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n = request.getParameter("username");
		List<String[]> user = UserDao.get_user_info(n);
		out.println("Welcome");
		
		for(String[] str : user) {
			out.println(str[0] + " : "+str[1]);
		}
		out.close();
	}
}
