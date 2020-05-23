

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class add
 */
@WebServlet("/calcPage")
public class CalcPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServletCalc3.html#HttpServlet()
     */
    public CalcPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String exp ="";
		Cookie[] cookies = request.getCookies();

		
	if(cookies != null) 
		for(Cookie c : cookies) 
			if(c.getName().equals("exp")) {
				exp=c.getValue();
				break;
		}
	
		
		
		
		
		PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("	<head>");
		out.write("	<meta charset=\"UTF-8\">");
		out.write("	<title>시;빨 왜안빠겨</title>");
		out.write("	<style>");
		out.write("	input{");
			out.write("		width:50px;");
			out.write("		height:50px;");
			out.write("	}");

			out.write("	.output {");
			out.write("		height:50px;");
			out.write("		background:#e9e9e9;");
			out.write("		font-size:24px;");
			out.write("		font-weight:bold;");
			out.write("	text-align:right;");
			out.write("	padding: 0 5px;");
			out.write("	}");
			out.write("	</style>");
			out.write("	</head>");
			out.write("	<body>");
			out.write("	out.write(\"		<form action=\"calc3\" method=\"post\">");
			out.write("	<table>");
			out.write("	<tr>");
			out.printf("		<td class=\"output\"colspan=\"4\">%s</td>",exp);
			out.write("	</tr>");
			out.write("	<tr>");
			out.write("			<td>");
			out.write("	<input type=\"submit\" name=\"operator\" value=\"CE\"/>");
							out.write("			</td>");
							out.write("		<td>");
						out.write("			<input type=\"submit\" name=\"operator\" value=\"C\"/>");
						out.write("		</td>");
						out.write("		<td>");
						out.write("			<input type=\"submit\" name=\"operator\" value=\"BS\"/>");
						out.write("			</td>");
						out.write("			<td>");
						out.write("				<input type=\"submit\" name=\"operator\" value=\"/\"/>");
						out.write("			</td>");
						out.write("		</tr>");
						out.write("		<tr>");
						out.write("			<td>");
						out.write("				<input type=\"submit\" name=\"value\" value=\"7\"/>");
						out.write("			</td>");
						out.write("			<td>");
						out.write("		<input type=\"submit\" name=\"value\" value=\"8\"/>");
						out.write("		</td>");
						out.write("		<td>");
						out.write("			<input type=\"submit\" name=\"value\" value=\"9\"/>");
						out.write("		</td>");
						out.write("		<td>");
						out.write("			<input type=\"submit\" name=\"operator\" value=\"*\"/>");
						out.write("		</td>");
						out.write("	</tr>");
						out.write("	<tr>");
						out.write("		<td>");
						out.write("			<input type=\"submit\" name=\"value\" value=\"4\"/>");
						out.write("		</td>");
						out.write("		<td>");
						out.write("			<input type=\"submit\" name=\"value\" value=\"5\"/>");
						out.write("			</td>");
						out.write("			<td>");
						out.write("			<input type=\"submit\" name=\"value\" value=\"6\"/>");
						out.write("	</td>");
						out.write("		<td>");
						out.write("			<input type=\"submit\" name=\"operator\" value=\"-\"/>");
						out.write("		</td>");
						out.write("	</tr>");
						out.write("	<tr>");
						out.write("		<td>");
						out.write("			<input type=\"submit\" name=\"value\" value=\"1\"/>");
						out.write("	</td>");
						out.write("	<td>");
						out.write("		<input type=\"submit\" name=\"value\" value=\"2\"/>");
						out.write("		</td>");
						out.write("		<td>");
						out.write("			<input type=\"submit\" name=\"value\" value=\"3\"/>");
							out.write("		</td>");
							out.write("		<td>");
							out.write("			<input type=\"submit\" name=\"operator\" value=\"+\"/>");
							out.write("		</td>");
							out.write("	</tr>");
							out.write("	<tr>");
							out.write("		<td>");
							
							out.write("		</td>");
							out.write("	<td>");
							out.write("		<input type=\"submit\" name=\"value\" value=\"0\"/>");
							out.write("		</td>");
							out.write("		<td>");
							out.write("			<input type=\"submit\" name=\"dot\" value=\".\"/>");
							out.write("		</td>");
							out.write("		<td>");
							out.write("			<input type=\"submit\" name=\"operator\" value=\"=\"/>");
							out.write("		</td>");
							out.write("	</tr>");
							out.write("</table>");
				
				
							out.write("</form>");
							out.write("		</body>");
							out.write("	</html>");

		
		
		
		
		
				}

}
