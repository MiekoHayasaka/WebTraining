package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Num;
import model.NumLogic;

/**
 * Servlet implementation class Calculation
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/calculation.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得
		String snum=request.getParameter("snum");

		//入力値をプロパティに設定
		Num num=new Num();
		num.setSnum(snum);

		//計算を実行し結果を設定
		NumLogic nl=new NumLogic();
		nl.execute(num);

		//リクエストスコープに保存
		request.setAttribute("num", num);

		//フォワード
		RequestDispatcher dp=request.getRequestDispatcher("/WEB-INF/jsp/calcuResult.jsp");
		dp.forward(request, response);
	}

}
