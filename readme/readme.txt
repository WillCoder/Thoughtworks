ThoughtWorks Sales Taxes Problem

Assumptions:	1. All text file inputs will be of the same format as those provided in the example --> ["quantity","item type","at","price]
		2. All outputs should be written in the same format as those provided in the example
		3. Since all the examples given are for product quantities = 1, it is assumed that if an input is given with quantities 
		greater than 1, the price of the item should be stated per "1 quantity" of that item
		4. All imported goods subject to import duty will contain the word imported in their description

To run:		Eclipse was used to create this project, and thus to run, unzip the project folder and run in Eclipse.	

NOTE**: 	Please note, I do not have a formal background in computer science/computer engineering and thus have not been formally taught 
		some of the major concepts such as TDD/unit testing, and as such, I have not implemented it in this problem due to learning time 
		constraints. 	

Application Structure:

MainProgram.java: 	Program starts in main() method of MainProgram class.
					input1.txt, input2.txt and input3.txt are the three example
					text files provided as inputs. The receipt/output can be found for
					any of these files by un-commenting their respective input lines at the beginning 
					of MainProgram.
					
					MainProgram then calls on ParseTxtFileInput.java and invokes the method
					parseInputFile();
					
					Once the ArrayList of Products is returned to the main program, the tax, and total
					price of each item (/product) is found by invoking methods of the IndividualItemTax.java class

Product.java		Creates Product objects containing the following fields:
					Product Type (String)
					Product Quantity (int)
					Product Price (float)
					Product is Imported (boolean - (if true, subject to import duty tax))
					Product is Exempt (boolean - (if true, it does not have basic sales tax))

ListofExemptGoods.java: Contains a method, getExemptGoods() which returns an ArrayList of Strings containing 
						keywords that specify certain goods that should be exempt from basic sales tax
						(such as food, books, medical products). This is kept as a separate class to make it 
						easy for the user to add/edit the list of exempt goods.

ParseTxtFileInput.java: ParseTxtFileInput contains a method parseInputFile(), which returns an ArrayList 
						of type <Product>, based on the input text file. BufferedReader(file) is used to 
						read the text file line by line. Each line of the text file is stored into an array 
						of strings split using white space delimiters. New Product objects are then created for 
						each line in the text file (specifying quantity, product type, price, whether or not it 
						is exempt from basic tax and whether or not it is imported).
						

IndividualItemTax.java: Constants specific to the problem are set at the top of this class, such as the basic sales 
						tax rate of 10%, the import duty of 5%, and the tax rounding of 0.05 (for 2 decimal places).
						This class contains 3 methods: 
						itemTax(): calculates the tax of each item
						priceWithTax(): calculates the price including tax of each item
						itemOutputString(): formulates the string which will be used as output for the receipt of each item

GenerateReceipt.java:	Using the receipt items string, sales tax float and total float as inputs,
						the receipt is printed (following the same output indicated in the problem statement)
