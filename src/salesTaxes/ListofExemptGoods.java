package salesTaxes;

import java.util.ArrayList;

public class ListofExemptGoods {

	private ArrayList<String> exemptGoods = new ArrayList<String>();
	
	//add any other key words here which specify an exempt good
	public ArrayList<String> getExemptGoods(){
		
		exemptGoods.add("books");
		exemptGoods.add("book");
		exemptGoods.add("food");
		exemptGoods.add("chocolate");
		exemptGoods.add("chocolates");
		exemptGoods.add("medical");
		exemptGoods.add("pills");
		exemptGoods.add("headache");
		
		return exemptGoods;
	}
	
	public int getLength(){
		
		return exemptGoods.size();
	}
	
	
	
}
