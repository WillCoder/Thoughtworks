package salesTaxes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainProgram {

	private static String itemOutput = null;
	private static ArrayList<String> itemReceipt = new ArrayList<String>();
	private static float totalItemPrice;
	private static float itemTax;
	
	private static float salesTax = 0.0f;
	private static float total = 0.0f;;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ParseTxtFileInput input = new ParseTxtFileInput("src/salesTaxes/input1.txt");
		//ParseTxtFileInput input = new ParseTxtFileInput("src/salesTaxes/input2.txt");
		//ParseTxtFileInput input = new ParseTxtFileInput("src/salesTaxes/input3.txt");
		
		ArrayList<Product> productArray = input.ParseInputFile();
		IndividualItemTax item = new IndividualItemTax();
		GenerateReceipt receipt = new GenerateReceipt();
		
		//A loop is used to loop through each item in the input file, for which the corresponding
		//item tax, total price, and item output string are found.
		for(int index = 0; index < productArray.size(); index++ ){
			
		
		itemTax = item.itemTax(		productArray.get(index).getQuantity(), 
									productArray.get(index).getPrice(), 
									productArray.get(index).getIsImported(), 
									productArray.get(index).getIsExempt() );
		
		totalItemPrice = item.priceWithTax(	itemTax, 
									productArray.get(index).getQuantity(), 
									productArray.get(index).getPrice() );
		
		
		itemOutput = item.itemOutputString(			totalItemPrice, 
													productArray.get(index).getQuantity(),
													productArray.get(index).getType());
		
		
		itemReceipt.add(index,itemOutput);
		
		salesTax += itemTax;
		total += totalItemPrice;
		}
		
		receipt.printReceipt(itemReceipt, salesTax, total);
	}

}