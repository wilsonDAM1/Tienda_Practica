package tienda;

public class Customer {
	private int id;
	private String name;
	private double balance; //balance=saldo
	
	public Customer(int id, String name, double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public int getId() { //Obtener identificador
		return id;
	}


	public String getName() { //Obtener nombre
		return name;
	}


	public double getBalance() { //Consultar saldo
		return balance;
	}

	public void sumarBalance(double dinero) {
	    balance += dinero;
	}

	public void restarBalance(double dinero) throws CantidadInsuficienteException {
		
		if (dinero > balance) {
			throw new CantidadInsuficienteException(
					"No tienes suficiente dinero"
					);
			}	
		
	    balance -= dinero;
	}
	
	public boolean comprobarCantidad(double dinero) { //comprobar unidades
		return  balance >= dinero ;
		}

	
	@Override
	public String toString() { //Obtener una representación textual del cliente
		return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
