package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/form.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得
		String weight=request.getParameter("weight");
		String height=request.getParameter("height");

		//入力値をプロパティに設定
		Health health=new Health(Double.parseDouble(height),Double.parseDouble(weight));

		//健康診断を実行し結果を設定
		HealthCheckLogic hc=new HealthCheckLogic();
		hc.execute(health);

		//リクエストスコープに保存
		request.setAttribute("health", health);

		//フォワード
		RequestDispatcher dp=request.getRequestDispatcher("/WEB-INF/view/result.jsp");
		dp.forward(request, response);
	}

}
