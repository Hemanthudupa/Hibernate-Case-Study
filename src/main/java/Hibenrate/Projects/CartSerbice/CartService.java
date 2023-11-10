package Hibenrate.Projects.CartSerbice;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Hibernate.Projects.Cart.Cart;
import Hibernate.Projects.CartDAO.CartDAO;
import Hibernate_Projects.Products.ProductDAO.ProductDAO;
import Hibernate_Projects.Products.createProduct.Product;

public class CartService {
	Cart cart=new Cart();
	private ProductDAO productDAO;
	public ProductDAO getProductDAO() {
		return productDAO;
	}
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	CartDAO cartDAO=new CartDAO();
	Scanner sc=new Scanner(System.in);
	Configuration con=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory sf = con.buildSessionFactory();
	public void addCart()
	{
		List<Product> allProducts = productDAO.getAllProducts();
		for(Product obj:allProducts)
		{
			System.out.println(obj.getProductId()+" "+obj.getProductName()+" "+obj.getProductPrice()+" "+obj.getProductQuantity());
		}
		System.out.println(" enter true if you want to add or false to exit ");
		boolean res=sc.nextBoolean();
		while(res) {
			System.out.println(" enter the id you want to Add to the cart");
			int prodid=sc.nextInt();
			Product product = productDAO.getProductById(prodid);
			cartDAO.addCart(product);
			System.out.println(" eneter true you you want to operation again or false for exit");
			res=sc.nextBoolean();
		}
	}
	public void deleteCart()
	{
		cartDAO.deleteCart();
	}
}