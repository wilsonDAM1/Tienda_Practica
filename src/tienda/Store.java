package tienda;

import java.io.File;
import java.util.ArrayList;

import java.util.Scanner;

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
		games.add(j1);
		games.add(j2);
		games.add(j3);
	}
	
	
	public void loadGames(String filename) throws Exception {
		File file = new File(filename);
		try (Scanner scanner = new Scanner(file)){
			String line = null;
			
			while(scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] splitLine = line.split(";");
				int id = Integer.parseInt(splitLine[0]);
				String name = splitLine[1];
				Genre genre = Genre.valueOf(splitLine[2]);
				double price = Double.parseDouble(splitLine[3]);
				int stock = Integer.parseInt(splitLine[4]);
				
				Game g = new Game(id, name, stock, price, genre);
				games.add(g);
				
			}
		}catch(Exception e) {
			
		}
	}
	
	public void loadCustomers (String filename) throws Exception{
		File file = new File(filename);
		
		try (Scanner reader = new Scanner(file)){
			String line = null;
			
			while(reader.hasNextLine()) {
				line = reader.nextLine();
				String[] splitLine = line.split(";");
				int id = Integer.parseInt(splitLine[0]);
				String name = splitLine[1];
				double balance = Double.parseDouble(splitLine[2]);
				
				Customer c = new Customer(id, name, balance);
				customers.add(c);
			}
		}catch(Exception e) {
			
		}
		
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
	
	public void comprarJuego(int clienteID, int juegoID, int cantidad) throws Exception{
		
		Game g = buscarJuegoPorId(juegoID);
		if(g == null) throw new Exception("No existe el juego");
		Customer c = buscarClientePorId(clienteID);
		if(c == null) throw new Exception("No existe el cliente");
		if(cantidad < 1) throw new Exception("Cantidad no valida");
		if(!g.comprobarStock(cantidad)) throw new Exception("No hay stock suficiente");
		
		double precio = g.getPrice() *cantidad;
		if(!c.checkBalance(g, cantidad)) throw new Exception("No hay stock suficiente");
		
		Purchase p = new Purchase(c, g, cantidad, precio);
		//Purchase p = new Purchase(c, g, cantidad);
		
	}
	
	public ArrayList<Game> getGames(){
		return games;
	}
	public ArrayList<Customer> getCustomers(){
		return customers;
	}
	
}
