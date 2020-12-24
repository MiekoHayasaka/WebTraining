package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String result=request.getParameter("result");
		String msg = "";
		if(result.equals("0")) {
			msg="正解！";
		}else {
			msg="不正解！";
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>"+msg+"</p>");
		out.println("<a href='index3.jsp'>戻る</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
