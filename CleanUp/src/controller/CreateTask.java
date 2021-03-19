package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;
import model.Task;

/**
 * Servlet implementation class CreateTask
 */
@WebServlet("/CreateTask")
public class CreateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskDAO dao = new TaskDAO();
		List<Task> list=dao.findAll();
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/create.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		//String day=request.getParameter("day");
		//String period=request.getParameter("period");
		String room_id=request.getParameter("room_id");
		//Calendar calendar = Calendar.getInstance();
		//Date updated=new Date();
		//Task task=new Task(name,Integer.parseInt(day),period,Integer.parseInt(room_id),(java.sql.Date) updated);
		Task task=new Task(name,Integer.parseInt(room_id));
		TaskDAO dao=new TaskDAO();
		dao.insertOne(task);

		response.sendRedirect("/CleanUp/Read");
	}

}
