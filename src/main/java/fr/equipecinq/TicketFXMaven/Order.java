package fr.equipecinq.TicketFXMaven;

import java.util.ArrayList;

public class Order {

	private ArrayList<Article> articlesList = new ArrayList<Article>();

	public Order() {
		this.articlesList = new ArrayList<Article>();
	}

	// Getter que j'utilise dans la classe ticket. Inutile si je parviens à rendre
	// Order itérable.
	public ArrayList<Article> getArticleList() {
		return this.articlesList;
	}

	// Ajout d'articles dans ma liste
	public void addArticle(Article article) {
		Boolean checkArticle = articlesList.stream().filter(a -> a.getName().equals(article.getName())).findFirst()
				.isPresent();
		if (checkArticle) {
			articlesList.stream().filter(a -> a.getName().equals(article.getName())).findFirst().get()
					.incrementAmount();
		} else {
			this.articlesList.add(article);
		}
	}

	// Méthodes de calcul des coûts totaux de la commande.
	public double totalOrder() {
		double total = 0;
		for (Article a : this.articlesList)
			total += a.totalLine();
		return total;
	}

	public String totalHtt() {
		return String.format("%.2f", (this.totalOrder() * (1 - 0.055)));
	}

	public String toString() {
		StringBuilder orderString = new StringBuilder();

		for (Article a : articlesList) {
			orderString.append(a.getName() + "\n" + a.getPrice() + "€ x" + a.getAmount() + "\n~~~~~~~~~~~~\n");
		}
		orderString.append("Total HTT " + totalHtt() + "€\n");
		orderString.append("Total  " + totalOrder() + "€\n");

		return orderString.toString();
	}

	public void clear() {
		articlesList.clear();
	}

}
