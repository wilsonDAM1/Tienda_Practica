package tienda;

import java.util.ArrayList;

public class Store {
	
	ArrayList<Game> games;
	ArrayList<Customer> customers;
	ArrayList<Purchase> purchases;
	
	public Store() {
		games = new ArrayList<Game>();
		customers = new ArrayList<Customer>();
		purchases = new ArrayList<Purchase>();
		
		Game j1 = new Game (1, "juego de prueba", 200, 23.79, Genre.ADVENTURE);
		Game j2 = new Game (2, "juego de prueba", 200, 23.79, Genre.ADVENTURE);
		Game j3 = new Game (3, "juego de prueba", 200, 23.79, Genre.ADVENTURE);
		
		games.add(new Game (1, "juego de prueba", 200, 23.79, Genre.ADVENTURE));
	}

	
	public void añadirJuego(Game game) {
	    for (Game g : games) {
	        if (game.equals(g)) /*throw new Exception ("El juego con id x ya existe")*/;
	        }
	    games.add(game);
	    }
	
	public Game buscarJuegoPorId(int id) /*throws IdInexistenteException*/ {
	    for (Game g : games) {
	        if (g.getId() == id) return g;
	        }
	    //throw new IdInexistenteException("No existe ningún videojuego con el ID: " + id);
	    return null;
	    }
	
	public Customer buscarClientePorId(int id) /*throws IdInexistenteException*/ {
	    for (Customer c : customers) {
	        if (c.getId() == id) return c;
	        }
	    //throw new IdInexistenteException("No existe ningún cliente con el ID: " + id);
	    return null;
	    }

	
	public ArrayList<Game> buscarJuegos(String name){
		String LowerName = name.toLowerCase();
		ArrayList<Game> juegos = new ArrayList<Game>();
		
		for(Game juego:games) {
			if(juego.getTittle().toLowerCase().contains(LowerName))juegos.add(juego);
		}
		return juegos;
	}
	
	public ArrayList<Game> buscarJuegos(Genre genre){
		ArrayList<Game> juegos = new ArrayList<Game>();
		for(Game juego:games) {
			if(juego.getGenre() == genre) juegos.add(juego);
			}
		return juegos;
	}
	
	/*public void comprarJuego(int clienteID, int juegoID, int cantidad) {
		if(buscarJuegoPorId(juegoID) == null) throw new Exception("No existe el juego");
		if(buscarClientePorId(clienteID) == null) throw new Exception("No existe el cliente");
		if(cantidad < 1) throw new Exception("Cantidad no valida");
		if(!Game.comprobarStock(cantidad)) throw new Exception("No hay stock suficiente");
		if(Customer.checkBalance(g, cantidad)) throw new Exception("No hay stock suficiente");
	}*/
	
	
	
	
	
}
