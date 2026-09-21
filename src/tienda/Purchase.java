package tienda;

public class Purchase {
	private Customer customer;
	private Game game;
	private int quantity;
	private double totalPrice;
	
	public Purchase(Customer customer, Game game, int quantity, double totalPrice) {
		this.customer = customer;
		this.game = game;
		this.quantity = quantity;
		this.totalPrice = game.getPrice() * quantity;
	}

	
	public Customer getCustomer() {
		return customer;
	}


	public Game getGame() { 
		return game;
	}


	public int getQuantity() {
		return quantity;
	}


	public double getTotalPrice() {
		return totalPrice;
	}
	
	@Override
	public String toString() {
		return "Purchase [customer=" + customer + ", game=" + game + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + "]";
	}

}
