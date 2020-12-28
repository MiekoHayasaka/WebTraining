package model;

import java.util.Random;

public class HeroLogic {
	//名前が決まったインスタンスから各パラメータを決定するメソッド
	public void init(Hero h) {
		int seed=0;
		for(int i=0;i<h.getName().length();i++) {
			seed += h.getName().charAt(i);
		}
		int[] vals=makeStatus(seed,new int[] {100,100,50,50,50});
		h.setHp(vals[0]);
		h.setMp(vals[1]);
		h.setPower(vals[2]);
		h.setDex(vals[3]);
		h.setAgi(vals[4]);
	}
	//シード値をもとにint配列を返却するメソッド
	private int[] makeStatus(int seed,int[] maxArr){
		int[] vals=new int[maxArr.length];
		Random rand=new Random(seed);
		for(int i=0;i<vals.length;i++){
			vals[i]=rand.nextInt(maxArr[i])+1;
		}
		return vals;
	}
	//人種が決まったインスタンスから各パラメータを変更するメソッド
	public void setRace(Hero h) {
		int[][] raceMatrix={
				{10,10,10,10,10},
				{0,20,0,10,20},
				{30,0,20,0,0},
				{10,0,0,25,20},
			};
		int index=Integer.parseInt(h.getRace());
		h.setHp(h.getHp()+raceMatrix[index][0]);
		h.setMp(h.getMp()+raceMatrix[index][1]);
		h.setPower(h.getPower()+raceMatrix[index][2]);
		h.setDex(h.getDex()+raceMatrix[index][3]);
		h.setAgi(h.getAgi()+raceMatrix[index][4]);
		String[] raceNames={"人間","ハイエルフ","トロル","ノーム"};
		h.setRace(raceNames[index]);

	}
	//職業が決まったインスタンスから各パラメータを調整し、
	//結果出力必要なフィールドを設定するメソッド
	public void setCls(Hero h) {
		double[][] clsMatrix={
				{1.6,1,1.4,1,1},
				{1.1,1,1.2,1.3,1.3},
				{1.3,1.5,1.1,1,1},
				{1,1.9,1,1,1.1},
			};
		int index=Integer.parseInt(h.getCls());
		h.setHp((int)(h.getHp()*clsMatrix[index][0]));
		h.setMp((int)(h.getMp()*clsMatrix[index][1]));
		h.setPower((int)(h.getPower()*clsMatrix[index][2]));
		h.setDex((int)(h.getDex()*clsMatrix[index][3]));
		h.setAgi((int)(h.getAgi()*clsMatrix[index][4]));
		String[] clsNames={"戦士","盗賊","僧侶","魔術師"};
		h.setCls(clsNames[index]);
		h.setTotal(h.getHp()+h.getMp()+h.getPower()+h.getDex()+h.getAgi());
		String[] keys= {"体力","魔力","きようさ","すばやさ","パワー"};
		int[] vals= {h.getHp(),h.getMp(),h.getPower(),h.getDex(),h.getAgi()};
		for(int i=0;i<vals.length-1;i++) {
			for(int j=i+1;j<vals.length;j++) {
				if(vals[i]<vals[j]) {
					String t1=keys[i];
					keys[i]=keys[j];
					keys[j]=t1;
					int t2=vals[i];
					vals[i]=vals[j];
					vals[j]=t2;
				}
			}
		}
		String[] ordered=new String[keys.length];
		for(int i=0;i<keys.length;i++) {
			String line=keys[i]+":"+vals[i];
			ordered[i]=line;
		}
		h.setOrdered(ordered);
	}
}