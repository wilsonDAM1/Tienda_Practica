package tienda;

import java.util.Scanner;

public class Tienda {

	public static void main(String[] args) throws Exception {
		
		Store store = new Store();
		store.loadCustomers("customers.txt");
		try {
			store.loadGames("games.txt");
		} catch (Exception e) {
			System.out.println("No se ha encontrado el archivo games.txt");
		}
		
		try (Scanner scanner = new Scanner(System.in)) {
			String input = "";
			while(!input.equals("quit")) {
				input = scanner.nextLine();
				
				String [] command = input.split(" ");
				
				switch(command[0]) {
				
				case "games":
					/*for(Game g: store.getGames)
						System.out.println(g.toText());*/
					System.out.println(store.getGames());
					break;
					
				case "game":
					int id = Integer.parseInt(command [1]);
					System.out.println(store.buscarJuegoPorId(id));
					break;
					
				case "customers":
					/*for(Game g: store.getGames)
						System.out.println(g.toText());*/
					System.out.println(store.getCustomers());
					break;
				case "search":
					System.out.println(store.buscarJuegos(command[1]));
					break;

				}
			}
			
		}
		
		
	}

}
