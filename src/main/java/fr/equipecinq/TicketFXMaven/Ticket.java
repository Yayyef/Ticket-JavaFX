package fr.equipecinq.TicketFXMaven;
//Je créé une classe séparée pour l'édition du ticket. Ceci dit, cela me contraint a créer un getter dans la classe Order et de récupérer l'arrayList pour pouvoir itérer sur ces éléments (Order n'est pas un type itérable).

public class Ticket {
	Order order;

	public Ticket(Order order) {
		this.order = order;
	}

	public void print() {
		System.out.println();
		System.out.println("\t\t*******CHEZ MOUNIR*******");
		System.out.println();

		for (Article a : this.order.getArticleList()) {

			System.out.println("\tArticle: " + a.getName());
			System.out.println(
					"\tx" + Integer.toString(a.getAmount()) + "         Prix: " + Double.toString(a.getPrice()));

			System.out.println();

		}

		System.out.println();
		System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println(String.format("\tTOTAL HORS TAXES %s", this.order.totalHtt()));
		System.out.println(String.format("\tTOTAL TTC %s", (this.order.totalOrder())));
		System.out.println();
		System.out.println("\t\tMerci pour votre achat!");
		System.out.println();
	}
	
	public String displayTicket() {
		StringBuilder ticketString = new StringBuilder();
		
		ticketString.append("\n" + "\t\t*******CHEZ MOUNIR*******" + "\n");
		
		for (Article a : this.order.getArticleList()) {

			ticketString.append("\tArticle: " + a.getName() + "\tx" + Integer.toString(a.getAmount()) + "         Prix: " + Double.toString(a.getPrice()) + "\n");

		}
		
		return ticketString.toString();
	}
}
