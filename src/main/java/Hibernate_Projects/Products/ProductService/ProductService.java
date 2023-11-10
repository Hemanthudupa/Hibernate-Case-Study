package Hibernate_Projects.Products.ProductService;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import Hibernate_Projects.Products.ProductDAO.ProductDAO;
import Hibernate_Projects.Products.createProduct.Product;

public class ProductService {
	ProductDAO productDAO = new ProductDAO();
	Scanner sc = new Scanner(System.in);

	public void addProduct() {
		Product product = new Product();
		System.out.println(" enter the name of the product");
		product.setProductName(sc.next());
		System.out.println(" enter the price of the product ");
		product.setProductPrice(sc.nextDouble());
		System.out.println(" enter the quantity of the product");
		product.setProductQuantity(sc.nextInt());
		String message = productDAO.addProduct(product);
		System.out.println(message);
	}

	public void updateProduct() {
		System.out.println(" enter the id to be updated ");
		int id = sc.nextInt();
		Product product = productDAO.getProductById(id);
		if (product != null) {
			System.out.println(" enter the name of the product");
			product.setProductName(sc.next());
			System.out.println(" enter the price of the product ");
			product.setProductPrice(sc.nextDouble());
			System.out.println(" enter the quantity of the product");
			product.setProductQuantity(sc.nextInt());
			productDAO.updateProduct(product);
		} else {
			System.err.println("product not found with given id");
		}
	}

	public void getProductById() {
		System.out.println(" enter the id for fetch the perticular record ");
		Product product = productDAO.getProductById(sc.nextInt());
		if (product != null)
			System.out.println(
					product.getProductId() + " , " + product.getProductName() + " , " + product.getProductPrice()
							+ " , " + product.getProductPrice() + " , " + product.getProductQuantity());
		else {
			System.err.println(" invalid id ,no such product there ");
		}
	}

	public void getAllTheProducts() {
		List<Product> allProducts = productDAO.getAllProducts();
		if (allProducts.isEmpty()) {
			System.err.println(" there is no products available here  ");
		}
		for (Product product : allProducts) {
			System.out.println(
					product.getProductId() + " , " + product.getProductName() + " , " + product.getProductPrice()
							+ " , " + product.getProductPrice() + " , " + product.getProductQuantity());
		}
	}

	public void deleteProduct() {
		System.out.println(" enter the id to delete");
		Product product = productDAO.getProductById(sc.nextInt());

		String message = productDAO.deleteProduct(product);
		System.out.println("the messags is " + message);
	}
}