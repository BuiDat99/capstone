package com.capstone.model;

public class ProductDTO {

	private int id;
	private String productName;
	private String image;
	private ResourceDTO resource;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(int id, String productName, String image, ResourceDTO resource) {
		super();
		this.id = id;
		this.productName = productName;
		this.image = image;
		this.resource = resource;
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

	public ResourceDTO getResource() {
		return resource;
	}

	public void setResource(ResourceDTO resource) {
		this.resource = resource;
	}
	
	
}
