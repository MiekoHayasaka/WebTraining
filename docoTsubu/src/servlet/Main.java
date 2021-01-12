package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MutterDAO;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// つぶやきリストを取得して、リクエストスコープに保存
 		MutterDAO dao = new MutterDAO();
 		List<Mutter> list = dao.findAll();
 		request.setAttribute("list", list);

		//ログインしているかどうか確認するためセッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		if(loginUser == null) { //ログインしていない場合
			//リダイレクト
			response.sendRedirect("/docoTsubu/");
		}else { //ログイン済みの場合
			//フォワード
			RequestDispatcher dp=request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dp.forward(request,response);
		}

 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//入力値チェック
		if(text != null && text.length() != 0) {
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");

			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(loginUser.getName(),text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);
		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}

		//つぶやきリストを取得して、リクエストスコープに保存
 		MutterDAO dao = new MutterDAO();
 		List<Mutter> list = dao.findAll();
 		request.setAttribute("list", list);

		//メイン画面にフォワード
		RequestDispatcher dp=request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dp.forward(request, response);
	}

}
