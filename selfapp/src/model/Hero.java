package model;

import java.io.Serializable;

public class Hero implements Serializable{
	//フィールド
	private String name;
	private String race;
	private String cls;
	private int hp;
	private int mp;
	private int power;
	private int dex;
	private int agi;
	private int total;
	private String[] ordered;

	//コンストラクタ
	public Hero() {}
	public Hero(String name) {
		this.name = name;
	}
	public Hero(String name, int hp, int mp, int power, int dex, int agi) {
		this(name);
		this.hp = hp;
		this.mp = mp;
		this.power = power;
		this.dex = dex;
		this.agi = agi;
	}
	public Hero(String name, String race, int hp, int mp, int power, int dex, int agi) {
		this(name,hp,mp,power,dex,agi);
		this.race=race;
	}
	public Hero(String name, String race,String cls, int hp, int mp, int power, int dex, int agi) {
		this(name,race,hp,mp,power,dex,agi);
		this.cls=cls;
	}
	//メソッド
	@Override
	public String toString() {
		return String.format("[体力:%d 魔力:%d パワー:%d きようさ:%d すばやさ:%d ]", this.hp,this.mp,this.power,this.dex,this.agi);
	}
	//setter&getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return this.race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String[] getOrdered() {
		return ordered;
	}
	public void setOrdered(String[] orderd) {
		this.ordered = orderd;
	}
}