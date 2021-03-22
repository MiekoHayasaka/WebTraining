package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.RankingResult;
import model.Score;

public class ScoreDAO {
private Connection db;
private PreparedStatement ps;
private ResultSet rs;

// 接続共通処理
private void connect() throws NamingException, SQLException {
	Context context = new InitialContext();
	DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsp");
	this.db = ds.getConnection();
}

// 切断共通処理
private void disconnect() {
	try {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (db != null) {
			db.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public void insertOne(Score score){
	try {
		this.connect();
		ps=db.prepareStatement("INSERT INTO scores(name,score,sex) VALUES(?,?,?)");
		ps.setString(1, score.getName());
		ps.setInt(2, score.getScore());
		ps.setInt(3, score.getSex());
		ps.executeUpdate();

	} catch (NamingException | SQLException e) {

		e.printStackTrace();
	}finally{
		this.disconnect();
	}
}

public void insertAll(List<Score> list){
	try {
		this.connect();
		db.setAutoCommit(false);
		ps=db.prepareStatement("INSERT INTO scores(name,score,sex) VALUES(?,?,?)");
		for(Score score:list){
			ps.setString(1, score.getName());
			ps.setInt(2, score.getScore());
			ps.setInt(3, score.getSex());
			ps.executeUpdate();
		}
		db.commit();
	} catch (NamingException | SQLException e) {
		e.printStackTrace();

	}finally{
		this.disconnect();
	}
}
public List<Score> find(int num){
	List<Score> list=new ArrayList<>();
	try {
		this.connect();
		ps=db.prepareStatement("SELECT * FROM scores ORDER BY score DESC LIMIT ?");
		ps.setInt(1, num);
		rs=ps.executeQuery();
		while(rs.next()) {
			Score score=new Score();
			score.setId(rs.getInt("id"));
			score.setName(rs.getString("name"));
			score.setScore(rs.getInt("score"));
			score.setSex(rs.getInt("sex"));
			list.add(score);
		}
	} catch (NamingException | SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}finally {
		this.disconnect();
	}
	return list;
}

public RankingResult getRankingResult(Score score,int count) {
	RankingResult result= new RankingResult();
	try {
		this.connect();
		ps=db.prepareStatement("INSERT INTO scores(name,score,sex) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, score.getName());
		ps.setInt(2, score.getScore());
		ps.setInt(3, score.getSex());
		ps.executeUpdate();

		rs=ps.getGeneratedKeys();
		if(rs.next()) {
			result.setLastId(rs.getInt(1));
		}

		ps=db.prepareStatement("SELECT COUNT(*) + 1 AS rank FROM scores WHERE score > ?");
		ps.setInt(1, score.getScore());
		rs=ps.executeQuery();
		if(rs.next()) {
			result.setRank(rs.getInt("rank"));
			result.setRankingIn(rs.getInt("rank")<count);
		}
		List<Score> list=new ArrayList<>();
		ps=db.prepareStatement("SELECT * FROM scores ORDER BY score DESC LIMIT ?");
		ps.setInt(1, count);
		rs=ps.executeQuery();

		while(rs.next()) {
			Score s=new Score();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setScore(rs.getInt("score"));
			s.setSex(rs.getInt("sex"));

			list.add(s);
		}
		result.setList(list);
	} catch (NamingException | SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
	return result;
}

}
