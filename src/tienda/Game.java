package tienda;

import Exceptions.CantidadInvalidaException;

public class Game {
	
	int id;
	String tittle;
	Genre genre;
	double price ;
	int stock;
	
	public Game(int id, String tittle, int stock, Double price, Genre genre) {
		this.id = id;
		this.tittle = tittle;
		this.stock = stock;
		this.price = price;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public int getStock() {
		return stock;
	}

	public String getTittle() {
		return tittle.toUpperCase();
	}


	public Double getPrice() {
		return price;
	}

	
	public Genre getGenre() {
		return genre;
	}
	
	public void aumentarStock(int cantidad) throws CantidadInvalidaException {
		if (cantidad < 0) throw new CantidadInvalidaException();
			stock += cantidad; 
		}


	public void reducirStock(int cantidad) throws CantidadInvalidaException { 
		
		if (cantidad < 0) throw new CantidadInvalidaException();
		if (cantidad > stock) throw new CantidadInvalidaException();
		
		stock -=cantidad;
	}
	
	public void modificarStock(int cantidad) throws CantidadInvalidaException {
		if(cantidad < 0) return;
		this.stock = cantidad;
	} 

	
	public boolean comprobarStock(int cantidad) {
		return stock >= cantidad ;
	}
	
	public boolean hayStock() {
		return stock >0;
	}
	
	public String toText() {
		return String.format("""
				ID: %d
				Tittle: %s
				Genre: %s
				Price: %.2f
				Stock: %d
				""",
				id, tittle, genre, price, stock);
	}
	
	public boolean equals(Object other) {
		if(other == this) return true;
		
		if(!(other instanceof Game)) return false;
		
		Game g = (Game)other;
		return id == g.getId();
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", tittle=" + tittle + ", genre=" + genre + ", price=" + price + ", stock=" + stock
				+ "]";
	}
	
}
