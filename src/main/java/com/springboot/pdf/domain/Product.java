package com.springboot.pdf.domain;

public class Product {

	//@Id
	private Integer id;

	private String name;

	private Double price;

	private Double salePrice;

	private Integer salesCount;

	private String saleDate;
	
	private String salesMan;

public Product() {
	
}

public Product(Integer id, String name, Double price, Double salePrice, Integer salesCount, String saleDate,
		String salesMan) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.salePrice = salePrice;
	this.salesCount = salesCount;
	this.saleDate = saleDate;
	this.salesMan = salesMan;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public Double getSalePrice() {
	return salePrice;
}

public void setSalePrice(Double salePrice) {
	this.salePrice = salePrice;
}

public Integer getSalesCount() {
	return salesCount;
}

public void setSalesCount(Integer salesCount) {
	this.salesCount = salesCount;
}

public String getSaleDate() {
	return saleDate;
}

public void setSaleDate(String saleDate) {
	this.saleDate = saleDate;
}

public String getSalesMan() {
	return salesMan;
}

public void setSalesMan(String salesMan) {
	this.salesMan = salesMan;
}

@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", price=" + price + ", salePrice=" + salePrice + ", salesCount="
			+ salesCount + ", saleDate=" + saleDate + ", salesMan=" + salesMan + "]";
}

}