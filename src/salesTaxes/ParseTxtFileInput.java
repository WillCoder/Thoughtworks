package salesTaxes;


import java.io.*;
import java.util.ArrayList;

public class ParseTxtFileInput {
	
	 private String inputFile;
	 private String productString = null;
	 private String[] productString_split = null;
	
	 private ListofExemptGoods exemptList = new ListofExemptGoods();
	
     public ParseTxtFileInput(String inputFile) {
            this.inputFile = inputFile;
     }
	
	//Converts text file input into array of strings 
	//where each element of the array corresponds to one product
    //entry details
	public ArrayList<Product> ParseInputFile()  throws FileNotFoundException, IOException {
		
		int stringArrayLength = 0;
		
		ArrayList<Product> products = new ArrayList<Product>();
		Product product_input = new Product();
		
		exemptList.getExemptGoods();
		int exemptListLength = exemptList.getLength();
		
		//data is retrieved from the text file using FileReader
		FileReader file = new FileReader(inputFile);
		//data obtained from FileReader is stored in buffer using BufferedReader
		BufferedReader buffered	= new BufferedReader(file);
		
		//Buffered text file is read line by line until next line is null (empty),
		//contents of each line in file are stored as a string in the string array goods 
		while( (productString = buffered.readLine()) != null){
			//productString = buffered.readLine();
			int i = 0;
			
			productString= productString.replaceAll( "\\s+$", "" );
			productString_split = productString.split(" ");
		
			//store the length of this string array in variable stringArrayLength
			stringArrayLength = productString_split.length;
			
			
			//System.out.println(productString);
			//System.out.println(Integer.parseInt(productString_split[0]));
			
			product_input.setQuantity(Integer.parseInt(productString_split[0]));
	
			//Create the string describing the type of product (i.e "box of chocolates")
			//Assuming all text file inputs follow the same format as those given in the examples,
			//
			String productType = "";
			//while( i < (stringArrayLength-3) ){
			for( i=1; i< (stringArrayLength-2); i++){
			productType = productType + productString_split[i] + " ";
			}
			
			product_input.setType(productType);
			product_input.setPrice(Float.parseFloat(productString_split[stringArrayLength-1]));
			
			//check if the string "imported" is used to describe the product
			//if so, then set imported property to true, otherwise false
			product_input.setIsImported(false);
			if(productType.contains("imported")){
				product_input.setIsImported(true);
			}
				
			//check if the product type is exempt from basic sales taxes (i.e is a book, food or medical product)
			//setting the isExempt field to true of false
			product_input.setIsExempt(false);
			
			for(int j=0; j< exemptListLength; j++)	{
				if(productType.contains(exemptList.getExemptGoods().get(j))){
					
					product_input.setIsExempt(true);
				}
			}
			products.add(new Product(	product_input.getType(), product_input.getQuantity(), 
										product_input.getPrice(), product_input.getIsImported(),
										product_input.getIsExempt()));
			
		}

	return products;
	}

}