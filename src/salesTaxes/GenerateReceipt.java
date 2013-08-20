package salesTaxes;

import java.util.ArrayList;

public class GenerateReceipt {

	/* printReceipt() prints out the output in the format requested in the problem
	 * */
	 
	public void printReceipt(ArrayList<String> receiptItems, float salesTax, float total){
		System.out.println("-------Receipt Details-------");
		
		for(int index=0; index<receiptItems.size(); index++){
		System.out.println(receiptItems.get(index));
		}
		
		/*since the float type of salesTax will truncate the 2nd (last) decimal 
		place if it is a zero, totalSalesTax string is used to check the decimal 
		places of the SalesTax before printing, appending a 0 if it has been truncated
		*/
		String totalSalesTax = String.valueOf(salesTax);
		if(totalSalesTax.length() < 4){
			totalSalesTax = totalSalesTax + "0";
		}
		
		System.out.println("Sales Taxes: " + totalSalesTax) ;
		System.out.println("Total: " + total);
		System.out.println("------------------------------");
	}

}
