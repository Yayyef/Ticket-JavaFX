package fr.equipecinq.TicketFXMaven;

public class Article {
	private String name;
	private int amount;
	private double price;
	
	public Article(String name, int amount, double price) {
		this.name = name;
		this.amount = amount;
		this.price = price;
	}
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

	// Mes getters
	public String getName() {
		return this.name;
	}
	public int getAmount() {
		return this.amount;
	}
	public double getPrice() {
		return this.price;
	}
	
	public void incrementAmount() {
		this.amount++;
	}
	
	
	// La méthode qui calcule le total pour un article
	public double totalLine() {
		return this.amount * this.price;
	}
	
	
}