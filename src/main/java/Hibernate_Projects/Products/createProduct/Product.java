package Hibernate_Projects.Products.createProduct;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String ProductName;
	private double ProductPrice;
	private int ProductQuantity;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}

	public int getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}

}
