package jdbc_test;

public class Product {
	private int prodID;
	private String name;
	private float price;
	private String productType;
	public int getProdID() {
		return prodID;
	}
	public Product(int prodID, String name, float price, String productType) {
		super();
		setProdID(prodID);
		setName(name);
		setPrice(price);
		setProductType(productType);
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
}
