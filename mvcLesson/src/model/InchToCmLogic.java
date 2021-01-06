package model;

public class InchToCmLogic {
	public void execute(InchToCm num){
		double inch=num.getInch();
		double cm=inch*2.54;
		num.setCm(cm);
	}
}
