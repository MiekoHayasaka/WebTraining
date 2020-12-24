package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String numa = request.getParameter("numa");
		String numb = request.getParameter("numb");

		String errorMsg="";
		if(numa==null || numa.length()==0) {
			errorMsg += "数値aが入力されていません<br>";
		}
		if(numb==null || numb.length()==0) {
			errorMsg += "数値bが入力されていません<br>";
		}

		int na = Integer.parseInt(numa);
		int nb = Integer.parseInt(numb);
		int sum = na+nb;
		String msg = na+ "+"+ nb +"="+ sum;
		if(errorMsg.length() !=0) {
			msg=errorMsg;
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>足し算結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>"+msg+"</p>");
		out.println("<a href=\"http://localhost:8080/formlesson2/index.jsp\">戻る</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
