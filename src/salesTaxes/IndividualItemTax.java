package salesTaxes;

import java.math.BigDecimal;

public class IndividualItemTax {
	
	//Define problem constants regarding taxes and rounding rules
	private static final float BASIC_SALES_TAX = 0.10f;
	private static final float IMPORT_DUTY = 0.05f;
	private static final float TAX_ROUNDING = 0.05f;
	private static final int DECIMAL_PLACES = 2;
	
	private static String itemToPrint = null;

	//This class will take in the product array as the input, 
	//and generate the sales tax of this product based on
	//product price, whether it is exempt, and whether it is imported

	//in the calculation of the tax, we are assuming the price listed for the product
	//is listed PER product
	public float itemTax(int quantity, float price, boolean isImported, boolean isExempt) {
		float tax = 0.0f;
		
		if(isExempt){
			if(isImported)
				tax = quantity*price*IMPORT_DUTY;
			else
				tax = 0;
		}
		else{
			if(isImported)
				tax = quantity*(price*BASIC_SALES_TAX + price*IMPORT_DUTY);
			else
				tax = quantity*price*BASIC_SALES_TAX;
		
		}
		tax = (float) ((Math.ceil(tax/TAX_ROUNDING))*TAX_ROUNDING);
			
		BigDecimal tax_rounded = new BigDecimal(tax).setScale(DECIMAL_PLACES,BigDecimal.ROUND_HALF_UP);
		tax = tax_rounded.floatValue();
		return tax;
	}
	
	public float priceWithTax(float tax, int quantity, float price) {
		float priceWithTax = 0;
		
		priceWithTax = quantity*price + tax;
		
		return priceWithTax;
	}
	
	public String itemOutputString(float priceWithTax, int quantity, String productType){
		//first convert the inputs to type string
		String priceWithTaxString = Float.toString(priceWithTax);
		String quantityString = Integer.toString(quantity);
	
		itemToPrint = quantityString + " " + productType + " " + ":" + " " + priceWithTaxString;
		
	return itemToPrint;	
	}


}
