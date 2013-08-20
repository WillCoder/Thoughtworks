package salesTaxes;


public class Product {

	private String productType;
	private int productQuantity;
	private float productPrice;
	private boolean productIsImported;
	private boolean productIsExempt;
	
	public Product() {
    }
	
	public Product(String productType, int productQuantity, float productPrice, boolean productIsImported, boolean productIsExempt) {
        super();
        this.productType = productType;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productIsImported = productIsImported;
        this.productIsExempt= productIsExempt;
	}
	
	
	public void setType(String productType){
		this.productType = productType;
	}
	public String getType(){
		return productType;
	}
	
	public void setQuantity(int productQuantity){
		this.productQuantity = productQuantity;
	}
	public int getQuantity(){
		return productQuantity;
	}
	
	public void setPrice(float productPrice){
		this.productPrice = productPrice;
	}
	
	public float getPrice(){
		return productPrice;
	}
	
	public void setIsImported(boolean productIsImported){
		this.productIsImported = productIsImported;
	}
	
	public boolean getIsImported(){
		return productIsImported;
	}
	
	public void setIsExempt(boolean productIsExempt){
		this.productIsExempt = productIsExempt;
	}
	
	public boolean getIsExempt(){
		return productIsExempt;
	}			

}