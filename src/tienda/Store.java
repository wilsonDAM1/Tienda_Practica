package tienda;

import java.util.ArrayList;

public class Store {
	
	ArrayList<Game> games = new ArrayList<Game>();
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Purchase> purchases = new ArrayList<Purchase>();

	
	public void añadirJuego(Game game) { //añadir videojuego
	    for (Game g : games) {
	        if (g.getId() == game.getId()) {
	            return;
	        }
	    }

	    games.add(game);
	}
	
	public Game buscarJuegoPorId(int id) throws IdInexistenteException {
	    for (Game game : games) {
	        if (game.getId() == id) {
	            return game;
	        }
	    }

	    throw new IdInexistenteException("No existe ningún videojuego con el ID: " + id);
	}
	
	public Customer buscarClientePorId(int id) throws IdInexistenteException {
	    for (Customer customer : customers) {
	        if (customer.getId() == id) {
	            return customer;
	        }
	    }

	    throw new IdInexistenteException("No existe ningún cliente con el ID: " + id);
	}
	
	public Game buscarJuegoPorTexto(String texto) throws NombreNoEncontrado{
	    for (Game game : games) {
	        if (game.getTittle().contains(texto.toUpperCase())) {
	            return game;
	        }
	    }
	    
	    throw new NombreNoEncontrado("No se ha encontrado ningún título relacionado a "+texto);
	}
	
}
