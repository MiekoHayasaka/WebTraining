package model;

import java.io.Serializable;

public class InchToCm implements Serializable{
	private double inch;
	private double cm;

	public InchToCm() {}

	public double getInch() {
		return inch;
	}

	public void setInch(double inch) {
		this.inch = inch;
	}

	public double getCm() {
		return cm;
	}

	public void setCm(double cm) {
		this.cm = cm;
	}



}
