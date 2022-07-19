package fr.equipecinq.TicketFXMaven;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
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

import java.io.IOException;
import java.util.ArrayList;

/**
 * CECI EST UN EXERCICE
 */
public class App extends Application {

    private static Scene scene;
    
    	@Override
    	public void start(Stage stage) throws IOException {
    		
    		scene = new Scene(loadFXML("primary"), 640, 480);
        	stage.setScene(scene);
        	stage.show();
    	}
        
		static void setRoot(String fxml) throws IOException {
			scene.setRoot(loadFXML(fxml));
		}
		
		private static Parent loadFXML(String fxml) throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
			return fxmlLoader.load();
		}
        
    public static void main(String[] args) {
        launch();
    }

}