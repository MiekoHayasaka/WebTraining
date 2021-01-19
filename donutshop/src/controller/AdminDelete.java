package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonutDAO;
import model.Donut;

/**
 * Servlet implementation class AdimiDelete
 */
@WebServlet("/Admin/Delete")
public class AdminDelete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		DonutDAO dao=null;
		if(id != null) {
			dao=new DonutDAO();
			dao.deleteOne(Integer.parseInt(id));
			List<Donut> list=dao.findAll();
			request.setAttribute("list", list);
			request.setAttribute("msg", "１件削除しました");
		}
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		rd.forward(request, response);
	}
}
