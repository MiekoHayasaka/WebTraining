package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hero;
import model.HeroLogic;

@WebServlet("/Second")
public class Second extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String race=request.getParameter("race");
		String name=request.getParameter("name");
		int hp=Integer.parseInt(request.getParameter("hp"));
		int mp=Integer.parseInt(request.getParameter("mp"));
		int power=Integer.parseInt(request.getParameter("power"));
		int dex=Integer.parseInt(request.getParameter("dex"));
		int agi=Integer.parseInt(request.getParameter("agi"));
		Hero h=new Hero(name,race,hp,mp,power,dex,agi);
		HeroLogic hl=new HeroLogic();
		hl.setRace(h);
		request.setAttribute("hero", h);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/clsForm.jsp");
		rd.forward(request, response);
	}

}