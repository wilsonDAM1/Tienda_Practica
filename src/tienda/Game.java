package tienda;

public class Game {
	
	private int id;
	private String tittle;
	private Genre genre;
	private Double price ;
	private int stock;
	
	public Game(int id, String tittle, Genre genre, Double price, int stock) {
		this.id = id;
		this.tittle = tittle;
		this.genre = genre;
		this.price = price;
		this.stock = stock;
	}

	public int getId() { //Obtener identificador
		return id;
	}


	public String getTittle() { //Obtener título
		return tittle.toUpperCase();
	}


	public Genre getGenre() { //Obtener el género
		return genre;
	}


	public Double getPrice() { //Obtener el precio
		return price;
	}


	public int getStock() { //Obtener el stock
		return stock;
	}

	public void setStock(int stock) { //Modificar el stock
		this.stock = stock;
	} 
	
	public void aumentarStock(int cantidad) { 
		stock += cantidad; 
	}
	
	
	public void reducirStock(int cantidad) throws CantidadInsuficienteException { 
		
		if (cantidad > stock) {
			throw new CantidadInsuficienteException(
					"No se puede reducir tanto stock"
					);
			}	
		
		stock -= cantidad; 
	}

	
	public boolean comprobarUnidades() { //comprobar unidades
		return stock > 0 ;
		}

	@Override
	public String toString() { //Obtener información del texto
		return "Game [id=" + id + ", tittle=" + tittle + ", genre=" + genre + ", price=" + price + ", stock=" + stock
				+ "]";
	}
	
}
