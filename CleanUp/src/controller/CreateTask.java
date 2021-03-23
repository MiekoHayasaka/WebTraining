package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;
import model.CalendarLogic;
import model.Room;
import model.Task;

/**
 * Servlet implementation class CreateTask
 */
@WebServlet("/CreateTask")
public class CreateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 登録した掃除場所の取得
		request.setCharacterEncoding("UTF-8");
		String room_id=request.getParameter("room_id");
		String rname=request.getParameter("rname");
		Room room=new Room(Integer.parseInt(room_id),rname);
		request.setAttribute("room", room);

		// タスクの一覧表示
		TaskDAO dao = new TaskDAO();
		List<Task> list=dao.findRoom(Integer.parseInt(room_id));
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/read.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パラメータを取得
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String s_day=request.getParameter("day");
		int day=Integer.parseInt(s_day);
		String period=request.getParameter("period");
		String s_room_id=request.getParameter("room_id");
		int room_id=Integer.parseInt(s_room_id);

		// 今日の日付を取得
		Date udate=new Date();
		java.sql.Date updated = new java.sql.Date(udate.getTime());

		// 次回掃除予定日までの日数を取得
		CalendarLogic cl=new CalendarLogic();
		int status=cl.Status(day,period,updated);

		// タスクの登録
		Task task=new Task(name,day,period,room_id,updated,status);
		TaskDAO dao=new TaskDAO();
		dao.insertOne(task);

		// 登録した掃除場所の取得
		String rname=request.getParameter("rname");
		Room room=new Room(room_id,rname);
		request.setAttribute("room", room);

		// タスクの一覧表示
		List<Task> list=dao.findRoom(room_id);
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/read.jsp");
		rd.forward(request, response);
	}

}
