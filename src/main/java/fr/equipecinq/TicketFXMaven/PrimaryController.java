package fr.equipecinq.TicketFXMaven;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PrimaryController implements Initializable{

	private static ArrayList<Article> starterArray = new ArrayList<Article>();
    private static ArrayList<Article> mainCourseArray = new ArrayList<Article>();
    private static ArrayList<Article> desertArray = new ArrayList<Article>();
    private static ArrayList<Article> drinksArray = new ArrayList<Article>();
    private static Order order = new Order();
    
    // FXML IDs
	public Tab startersTab;
	public Tab mainCoursesTab;
	public Tab desertsTab;
	public Tab drinksTab;
	public Button printButton;
	public Button cancelButton;
	public VBox orderBox;
	public TabPane tabs;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		loadArrays();
		createTabs(tabs);
		createCancelButton();
		createPrintButton();
	}
	
	public void createTabs(TabPane tabPane) {
		
		tabs.getTabs().addAll(
				generateTab("Starter", starterArray),
				generateTab("Main", mainCourseArray),
				generateTab("Deserts", desertArray),
				generateTab("Drinks", drinksArray)
				);
	}
	
	public Tab generateTab(String name, ArrayList<Article> type) {
		Tab tab = new Tab(name);
		tab.setContent(generateGrid(type));
		return tab;
	}
	
    public GridPane generateGrid(ArrayList<Article> articles) {
		GridPane articlesGrid = new GridPane();
		int col = 0;
		int row = 0;
		for (Article a : articles) {
			if (col == 3) {
				col = 0;
				row++;
			}
			articlesGrid.add(addArticleGrid(a), col, row);
			col++;
		}
		return articlesGrid;
	}
	
    @FXML
    public GridPane addArticleGrid(Article article) {
    	GridPane articleGrid = new GridPane();
    	articleGrid.setPadding(new Insets(20));
    	Button articleBtn = new Button(article.getName());
    	articleBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				order.addArticle(article);
				Text orderDisplay = new Text(order.toString());
				orderBox.getChildren().clear();
				orderBox.getChildren().add(orderDisplay);
			}
		});
    	
    	Text price = new Text(Double.toString(article.getPrice()) + "€");
    	articleGrid.add(articleBtn, 0, 0);
    	articleGrid.add(price, 0, 1);
    	return articleGrid;
    }
    
    public void createCancelButton() {
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				orderBox.getChildren().clear();
				order.clear();
			}
		});
//		return cancelButton;
    }
    
    // L'événement créé une nouvelle fenêtre où afficher le ticket de la commande
    public void createPrintButton() {
		Stage newWindow = new Stage();
		printButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Ticket ticket = new Ticket(order);
				ticket.print();
				
				StackPane ticketPane = new StackPane();
				ticketPane.getChildren().add(new Text(ticket.displayTicket()));
				
				Scene newScene = new Scene(ticketPane);
				newWindow.setScene(newScene);
				newWindow.show();
			}
			
			
		});
//		return printButton;
    }

    private void loadArrays() {
    	starterArray.add(new Article("Mozza Sticks", 1, 4));
		starterArray.add(new Article("Fries", 1, 4));
		starterArray.add(new Article("Curly Fries", 1, 4));
		starterArray.add(new Article("Chicken Fingers", 1, 4));
		
		mainCourseArray.add(new Article("Panini", 1, 4));
		mainCourseArray.add(new Article("Burger", 1, 4));
		mainCourseArray.add(new Article("Cheeseburger", 1, 4));
		mainCourseArray.add(new Article("Wrap", 1, 4));
		mainCourseArray.add(new Article("Ceasar Salad", 1, 4));
		mainCourseArray.add(new Article("Bucket", 1, 4));
		mainCourseArray.add(new Article("Chicken Roll", 1, 4));
		mainCourseArray.add(new Article("Sandwich", 1, 4));
		mainCourseArray.add(new Article("Burrito", 1, 4));
		mainCourseArray.add(new Article("Kebab", 1, 4));
		
		desertArray.add(new Article("Milkshake", 1, 4));
		desertArray.add(new Article("Frappé", 1, 4));
		desertArray.add(new Article("Ice Cream", 1, 4));
		desertArray.add(new Article("Chocolate mousse", 1, 4));
		desertArray.add(new Article("Opera Cake", 1, 4));
		
		drinksArray.add(new Article("Coca", 1, 4));
		drinksArray.add(new Article("Sprite", 1, 4));
		drinksArray.add(new Article("Fanta", 1, 4));
		drinksArray.add(new Article("Ice Tea", 1, 4));
		drinksArray.add(new Article("Orange Juice", 1, 4));
		drinksArray.add(new Article("Coffee", 1, 4));
    }

	
}
