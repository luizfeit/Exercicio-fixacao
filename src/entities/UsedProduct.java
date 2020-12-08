package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	public static final SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyy");
	
	private Date manufactureDate;
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	@Override
	public String priceTag() {
		return getName() + "(Used) $ "+getPrice()+ " (Manufacture data: "+sdf.format(manufactureDate)+")" ;
	}
	
}
