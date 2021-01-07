package model;

import java.util.List;

public class ProductLogic {
	public void execute(List<Product> list){
		int sum=0;
		for(Product p:list) {
			sum += Integer.parseInt(p.getPrice());
		}

	}
}
