package Hibernate_Projects.Products.ProductDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import Hibernate_Projects.Products.createProduct.Product;

public class ProductDAO {
Configuration con=new Configuration().configure().addAnnotatedClass(Product.class);
 SessionFactory factory= con.buildSessionFactory();
 public String addProduct(Product product)
 {
	 Session session = factory.openSession();
	 Transaction trans = session.beginTransaction();
	 session.save(product);
	 trans.commit();
	 session.close();
	 return "product successfully added";
 }
 public Product getProductById(int id)
 {
	 Session session = factory.openSession();
	 Transaction trans = session.beginTransaction();
	Product product= session.get(Product.class, id);
	trans.commit();
	session.close();
	return product;
 }
 public List<Product> getAllProducts()
 {
	 Session session = factory.openSession();
	 Transaction trans = session.beginTransaction();
	 org.hibernate.query.Query<Product> query= session.createQuery("from Product");
 List<Product> products = query.list();
 trans.commit();
 session.close();
 return products;
 }
 public String updateProduct(Product product)
 {
	 Session session = factory.openSession();
	 Transaction trans = session.beginTransaction();
	 session.update(product);
	 trans.commit();
	 return "updated successfully";
 }
 public String deleteProduct(Product  product)
 {
	 if(product!=null) {
	 Session session = factory.openSession();
	 Transaction trans = session.beginTransaction();
	 session.delete(product);
	 trans.commit();
	 return "deleted successfully";
 }
	 else
		 return " object not found to delete";
 }
}
