

public class Stock {
	private String name;
	private String ID;
	private int Quantity;
	public Stock(String iD, String name, int quantity) {
		this.name = name;
		ID = iD;
		Quantity = quantity;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}