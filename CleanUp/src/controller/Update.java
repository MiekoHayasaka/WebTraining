package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoomDAO;
import dao.TaskDAO;
import model.Room;
import model.Task;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String room_id=request.getParameter("room_id");
		String s_id=request.getParameter("id");
		if(s_id == null) {
			response.sendRedirect("/CleanUp/CreateTask");
		}else {
			RoomDAO rdao=new RoomDAO();
			Room room = rdao.findOne(Integer.parseInt(room_id));
			request.setAttribute("room", room);
			TaskDAO dao=new TaskDAO();
			Task task = dao.findOne(Integer.parseInt(s_id));
			request.setAttribute("task", task);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/update.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// タスクの更新
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String day=request.getParameter("day");
		String period=request.getParameter("period");
		String id=request.getParameter("id");
		String room_id=request.getParameter("room_id");
		Task task=new Task(Integer.parseInt(id),name,Integer.parseInt(day),period,Integer.parseInt(room_id));
		TaskDAO dao=new TaskDAO();
		dao.updateOne(task);

		// 更新した掃除場所の取得
		//String room_id=request.getParameter("room_id");
		String rname=request.getParameter("rname");
		Room room=new Room(Integer.parseInt(room_id),rname);
		request.setAttribute("room", room);

		// タスクの一覧表示
		List<Task> list=dao.findRoom(Integer.parseInt(room_id));
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/read.jsp");
		rd.forward(request, response);
	}
}
