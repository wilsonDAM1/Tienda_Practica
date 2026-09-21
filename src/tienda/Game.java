package tienda;

import Exceptions.CantidadInvalidaException;

public class Game {
	
	private int id;
	private String tittle;
	private Genre genre;
	private Double price ;
	private int stock;
	
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

	@Override
	public String toString() {
		return "Game [id=" + id + ", tittle=" + tittle + ", genre=" + genre + ", price=" + price + ", stock=" + stock
				+ "]";
	}
	
}
