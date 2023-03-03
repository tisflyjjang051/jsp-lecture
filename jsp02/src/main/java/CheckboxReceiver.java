
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckboxReceiver")
public class CheckboxReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckboxReceiver() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String interestList [] = request.getParameterValues("interest");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>당신의 관심사는?</h1>");
		out.println("<ul>");
		for(int i=0;i<interestList.length;i++) {
			out.println("<li>"+interestList[i]+"</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
