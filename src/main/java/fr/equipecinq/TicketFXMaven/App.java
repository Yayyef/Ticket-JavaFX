package fr.equipecinq.TicketFXMaven;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static ArrayList<Article> articles = new ArrayList<Article>();
    private static Order order = new Order();
    private static VBox orderBox = new VBox();
    
    	
    	public void start(Stage stage) throws IOException {
    		
    		
    		
    		articles.add(new Article("Panini", 1, 4));
    		articles.add(new Article("Burger", 1, 4));
    		articles.add(new Article("Cheeseburger", 1, 4));
    		articles.add(new Article("Wrap", 1, 4));
    		articles.add(new Article("Ceasar Salad", 1, 4));
    		
    		
    		
    		GridPane grid = new GridPane();
//    		grid.setMinWidth(800);
    		grid.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
    		
    		generateGrid(grid, articles);
    		
    		orderBox.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
    		
    		
    		Button printButton = new Button("Print Ticket");
    		printButton.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					Ticket ticket = new Ticket(order);
					ticket.print();
					
					Popup pop = new Popup();
					Text printed = new Text(ticket.displayTicket());
					pop.getContent().add(printed);
					if (!pop.isShowing())
	                    pop.show(stage);
	                else
	                    pop.hide();
				}
			});
    		Button cancelButton = new Button("Cancel Order");
    		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					orderBox.getChildren().clear();
					order.clear();
				}
			});
    		
    		VBox rightBox = new VBox(orderBox, printButton, cancelButton);
    		
    		HBox mainBox = new HBox(grid, rightBox);
    		
    		scene = new Scene(mainBox, 600, 600);
        	stage.setScene(scene);
        	stage.show();
    	}
    	
    	public static void generateGrid(GridPane articlesGrid, ArrayList<Article> articles) {
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
    	}
    	
        public static GridPane addArticleGrid(Article article) {
        	GridPane articleGrid = new GridPane();
        	articleGrid.setPadding(new Insets(20));
        	Button articleBtn = new Button(article.getName());
        	articleBtn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
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
        
        public static void clearOrder() {
        	orderBox.getChildren().clear();
        }
        
    public static void main(String[] args) {
        launch();
    }

}

//@Override
//public void start(Stage stage) throws IOException {
//	
//	GridPane grid = new GridPane();
//	
//	
//  scene = new Scene(loadFXML("primary"), 640, 480);
//  stage.setScene(scene);
//  stage.show();
//}
//
//static void setRoot(String fxml) throws IOException {
//  scene.setRoot(loadFXML(fxml));
//}
//
//private static Parent loadFXML(String fxml) throws IOException {
//  FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//  return fxmlLoader.load();
//}