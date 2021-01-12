package model;

import dao.MutterDAO;

public class PostMutterLogic {
	public void execute(Mutter mutter) {
		MutterDAO dao=new MutterDAO();
		//つぶやきの投稿処理を行う
		dao.insertOne(mutter);
	}
}
