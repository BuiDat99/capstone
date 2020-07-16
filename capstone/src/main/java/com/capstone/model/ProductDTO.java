package com.capstone.model;

public class ProductDTO {

	private int id;
	private String productName;
	private String image;
	private ProductResource productResource;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(int id, String productName, String image, ProductResource productResource) {
		super();
		this.id = id;
		this.productName = productName;
		this.image = image;
		this.productResource = productResource;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ProductResource getProductResource() {
		return productResource;
	}

	public void setProductResource(ProductResource productResource) {
		this.productResource = productResource;
	}
	
	
}
