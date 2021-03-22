package model;

import java.io.Serializable;
//import java.util.Date;
import java.sql.Date;

public class Task implements Serializable{
	private int id;
	private String name; // タスク名
	private int room_id;
	private int day; // 1～31
	private String period; // 日、週、ケ月、年
	private int season; // 期間限定（１月～１２月）
	private Date updated;
	//private Calendar calendar;
	private int frequency; // 入力されたday,periodから日数を取得
	//private int importance; // 重要度

	public Task() {}
/*
	public Task(String name,int day,String period,int room_id) {
		this.name=name;
		this.day=day;
		this.period=period;
		this.room_id=room_id;
		//this.importance=importance;
	}
	*/
	// 登録時
	public Task(String name,int day,String period,int room_id, Date updated) {
		this.name=name;
		this.day=day;
		this.period=period;
		this.room_id=room_id;
		this.updated=updated;
	}
	// 更新時
	public Task(int id,String name,int day,String period,int room_id) {
		this.id=id;
		this.name=name;
		this.day=day;
		this.period=period;
	}
	// 一覧表示
	public Task(int id,String name,int day,String period,int room_id,Date updated) {
		this(name,day,period,room_id,updated);
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
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}


}
