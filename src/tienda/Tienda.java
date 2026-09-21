package tienda;

import java.util.Scanner;

public class Tienda {

	public static void main(String[] args) {
		
		
		/*Game juego = new Game(1, "juego de prueba", 200, 23.79, Genre.ADVENTURE);
		System.out.println(juego.toText());*/
		Store store = new Store();
		
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
					System.out.println();

				}
			}
			
		}
		
		
	}

}
