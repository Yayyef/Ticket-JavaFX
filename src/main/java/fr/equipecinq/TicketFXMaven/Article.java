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
	
	
	
	// La méthode qui calcule le total pour un article
	public double totalLine() {
		return this.amount * this.price;
	}
	
	
}