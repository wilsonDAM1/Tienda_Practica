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
		this.totalPrice = totalPrice = quantity * game.getPrice();
	}

	public Customer getCustomer() { //cliente que realizó la compra
		return customer;
	}


	public Game getGame() {  // videojuego comprado
		return game;
	}


	public int getQuantity() { // número de unidades
		return quantity;
	}


	public double getTotalPrice() { //precio total de la compra
		return totalPrice;
	}

	
	@Override
	public String toString() {
		return "Purchase [customer=" + customer + ", game=" + game + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + "]";
	}
	
	

}
