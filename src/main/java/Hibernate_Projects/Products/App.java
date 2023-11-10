package Hibernate_Projects.Products;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import Hibenrate.Projects.CartSerbice.CartService;
import Hibernate_Projects.Products.ProductService.ProductService;
public class App 
{
	private static CartService bean; 
	private static ProductService bean2;
	public CartService getBean() {
		return bean;
	}
	public void setBean(CartService bean) {
		App.bean = bean;
	}
	public ProductService getBean2() {
		return bean2;
	}
	public void setBean2(ProductService bean2) {
		App.bean2 = bean2;
	}
	public static void main( String[] args ) throws InterruptedException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Scanner sc=new Scanner(System.in);
		System.out.println(" print true if you want to do any operations or print false to stop operations ");
		boolean opt=sc.nextBoolean();
		while(opt)
		{
			System.out.println(" press 1 for adding product \n press 2 for updating product \n press 3 for deleting the product \n press 4 for get product by ID "
					+ "\n press 5 for get all the products \n press 6 to add the product to cart \n press 7 to remove product from the cart ");
			System.out.println(" enter the choice ");
			switch(sc.nextInt())
			{
			case 1:bean2.addProduct();
			break;
			case 2:bean2.updateProduct();
			break;
			case 3:bean2.deleteProduct();
			break;
			case 4:bean2.getProductById();
			break;
			case 5:bean2.getAllTheProducts();
			break;
			case 6:bean.addCart();
			break;
			case 7:bean.deleteCart();
			break;
			default:System.err.println(" invalid option ");
			break;
			}
			Thread.sleep(2000);
			System.out.println(" if you want to do any opertaions again press true or press false ");
			opt=sc.nextBoolean();
		}
		sc.close();
	}
}