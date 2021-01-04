package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dice;
import model.DiceLogic;
import model.Statistics;


@WebServlet("/Main")
public class Main extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application=this.getServletContext();
		Statistics stat=(Statistics)application.getAttribute("stat");
		if(stat ==null) {
			stat=new Statistics();
		}

		// sessionインスタンス取得
		HttpSession session=request.getSession();
		//sessionからダイスインスタンスの取得を試みる
		Dice dice=(Dice)session.getAttribute("dice");
		//sessionに無い(初めて)かCompleteの文字が含まれていれば最初から
		if(dice == null || dice.getMsg().contains("Complete")) {
			//新規にダイスインスタンス作成
			dice=new Dice();
		}else {
			DiceLogic dl=new DiceLogic();
			//ダイスを振る処理を行う
			dl.throwDice(dice);
		}
		//sessionスコープにダイスインスタンスを詰める
		session.setAttribute("dice", dice);
		//フォーワード
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}

}
