package Hibernate.Projects.CartDAO;

import java.util.List;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Hibernate.Projects.Cart.Cart;
import Hibernate_Projects.Products.ProductDAO.ProductDAO;
import Hibernate_Projects.Products.createProduct.Product;

public class CartDAO {
	Cart cart=new Cart();
	ProductDAO productDAO=new ProductDAO();

	Configuration con=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory sf = con.buildSessionFactory();
	public Session getSession()
	{
		Configuration con=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
	public void addCart(Product product)
	{
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		if(product!=null) {
			List<Product> products = cart.getProducts();
			products.add(product);
			session.save(cart);
			trans.commit();
			System.out.println(" product successfully added to Cart ");
		}
		else
		{
			System.err.println(" unable to add product to the cart");
		}
	}
	public void deleteCart()
	{
		Scanner sc=new Scanner(System.in);
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		System.out.println(" enter cart id");
		Cart cart=session.get(Cart.class, sc.nextInt());
		System.out.println(" enter product id");
		Product product=session.get(Product.class, sc.nextInt());
		cart.getProducts().remove(product);
		session.update(cart);
		trans.commit();
		session.close();
		sc.close();
	}
}