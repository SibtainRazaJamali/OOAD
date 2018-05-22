package application;
	

import application.view.FirstPageController;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Daewoo Service Management System");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/FirstPage.fxml"));
			BorderPane root = new BorderPane();
			root=(BorderPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			FirstPageController fpc=loader.getController();
			fpc.setMainStage(primaryStage);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
