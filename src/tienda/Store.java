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
	
	public Game buscarJuegoPorTexto(String texto) throws NombreNoEncontradoException{
	    for (Game game : games) {
	        if (game.getTittle().contains(texto.toUpperCase())) {
	            return game;
	        }
	    }
	    throw new NombreNoEncontradoException("No se ha encontrado ningún título relacionado a "+texto);
	}
	
	public Game filtrarPorGenero(String texto) throws GeneroInexistenteException{
	    for (Game game : games) {
	        if (game.getGenre().name().contains(texto.toUpperCase())) {
	            return game;
	        }
	    }
	    throw new GeneroInexistenteException("No se ha encontrado ningún título del tipo "+texto);
	}
	
	/*public void comprobarCompra(Purchase purchase) throws IdInexistenteException {
	    buscarClientePorId(purchase.getCustomer().getId());
	    buscarJuegoPorId(purchase.getGame().getId());
	    throw new IdInexistenteException("No se ha podido continuar con la compra porque no existe el cliente o el producto");
	    if (purchase.getQuantity() <= 0) {
	    }
	    
	}
	
	public boolean realizarCompra(int game, int id, int customer) throws CompraInexistenteException{
		
	}*/
	
	
	
	
	
}
