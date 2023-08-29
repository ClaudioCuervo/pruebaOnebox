package com.claudio.pruebaOnebox;

public class Product {
	
	public int id;
	public String description;
	public double amount;

	
	public Product () {

	    }

	public Product (int id, String description, double amount) {
		
		this.id = id;
	    this.description = description;
	    this.amount = amount;
	    }
	
	
	public static String getProductInfo(Product product) {
		String productInfo = "\nId: " + product.getId()  + "\nDescription: " + product.getDescription()  + "\nAmount: " + product.getAmount();
		return productInfo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
