package model;

import java.io.Serializable;

public class Product implements Serializable{
	private String name;
	private String price;
	private String sum;
	public Product(){}
	public Product(String name,String price){
		this.name=name;
		this.price=price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}


}
