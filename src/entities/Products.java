package entities;

public class Products {
	private Integer id;
	private String nameProduct;
	private Double price;
	
	public Products() {
		
	}

	public Products(Integer id, String nameProduct, Double price) {
		this.id = id;
		this.nameProduct = nameProduct;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Double getPrice() {
		return price;
	}

	public String toString() {
		return "ID: "
				+ id
				+ ", Name: "
				+ nameProduct
				+ ", Preço: "
				+ price;
	}
	
	
	
	
}
