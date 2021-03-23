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
 * Servlet implementation class Complete
 */
@WebServlet("/Complete")
public class Complete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 次回掃除予定日の更新
		String s_id=request.getParameter("id");
		TaskDAO dao=new TaskDAO();
		Task task=dao.findOne(Integer.parseInt(s_id));
		java.sql.Date updated=task.getUpdated();
		CalendarLogic cl=new CalendarLogic();
		int status=cl.Status(day,period,updated);
		task.setStatus(status);

		// 今日の日付を取得
		Date udate=new Date();
		java.sql.Date sdate = new java.sql.Date(udate.getTime());
		//Task task=new Task();
		task.setId(Integer.parseInt(s_id));
		task.setUpdated(sdate);
		// タスクの更新
		//TaskDAO dao=new TaskDAO();
		dao.updateStatus(task);

		// 更新した掃除場所の取得
		String room_id=request.getParameter("room_id");
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
