package fr.equipecinq.TicketFXMaven;

public enum ArticleEnum {
	
	PANINI(4, 2);
	
	private int amount;
	private double price;
	
//	enum MainCourse {
//		PANINI(4.0, 1)
//		
//		private 
//	}
	
	private ArticleEnum(int amount, double price) {
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