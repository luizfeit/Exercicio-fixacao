package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner (System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyy");
		
		List<Product> list=new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {			
			System.out.println("Product # "+i+" data:");
			System.out.print("Common, used or imported(c/u/i)? ");
			char im=sc.next().charAt(0);
			
			if(im=='i') {
				sc.nextLine();
				System.out.print("Name: ");
				String name=sc.nextLine();
				System.out.print("Price: ");
				Double price=sc.nextDouble();
				System.out.print("Customs fee: ");
				Double customsFee=sc.nextDouble();	
				Product product=new ImportedProduct(name, price, customsFee);
				list.add(product);
			}
			else if(im=='c') {
				sc.nextLine();
				System.out.print("Name: ");
				String name=sc.nextLine();
				System.out.print("Price: ");
				Double price=sc.nextDouble();
				Product product=new Product(name, price);
				list.add(product);
				}
			
			else if(im=='u') {
				sc.nextLine();
				System.out.print("Name: ");
				String name=sc.nextLine();
				System.out.print("Price: ");
				Double price=sc.nextDouble();
				System.out.print("Manufacture date(DD/MM/YYY): ");
				Date date= sdf.parse(sc.next());
				Product product=new UsedProduct(name, price, date);
				list.add(product);
				
			} 
			else {
				System.out.println("Opção invalida");
			}
		}
		System.out.println();
		System.out.println("Price tags: ");
		
		for(Product product: list) {
			System.out.println(product.priceTag());
		}
		sc.close();

	}

}
