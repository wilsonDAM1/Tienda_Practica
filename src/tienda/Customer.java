package tienda;

import Exceptions.CantidadInvalidaException;

public class Customer {
	
	static int contador = 0;
	
	int id;
	String name;
	double balance;
	
	public Customer (String name) {
		this.id = ++contador;
		this.name = name;
		this.balance = 0;
	}
	
	public Customer(int id, String name, double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public double getBalance() {
		return balance;
	}

	public void añadirSaldo(double saldo) throws CantidadInvalidaException {
		if (saldo < 0) throw new CantidadInvalidaException();
	    balance += saldo;
	}

	public void reducirSaldo(double saldo) throws CantidadInvalidaException { 
		
		if (saldo < 0) throw new CantidadInvalidaException();
		if (saldo > balance) throw new CantidadInvalidaException();
		
	    balance -= saldo;
	}
	
	public boolean checkBalance(double cantidad) {
		return  balance >= cantidad;
	}
	
	public boolean checkBalance(Game game, int cantidad) {
		return balance >= game.getPrice() * cantidad;
	}
	
	public String toText() {
		return String.format("""
				ID: %d
				Name: %s
				Balance: %.2f
				""",
				id, name, balance);
	}

	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
