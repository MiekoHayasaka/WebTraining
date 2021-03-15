package model;

import java.io.Serializable;

public class Task implements Serializable{
	private int id;
	private String name; // タスク名
	private int num; // 1～31
	private String period; // 日、週、ケ月、年
	private int season; // 期間限定（１月～１２月）
	//private int frequency; // 入力されたnum,periodから日数を取得
	private int importance; // 重要度

	public Task() {}
	public Task(String name,int num,String period,int season,int importance) {
		this.name=name;
		this.num=num;
		this.period=period;
		this.season=season;
		this.importance=importance;
	}
	public Task(int id,String name,int num,String period,int season,int importance) {
		this(name,num,period,season,importance);
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}

}
