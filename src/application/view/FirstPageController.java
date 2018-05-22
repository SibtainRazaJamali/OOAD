package application.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FirstPageController implements Initializable 
{
	@FXML 
	private Stage mainApp;
	@FXML
	private Stage prevStage;
	public FirstPageController() 
	{
		mainApp=new Stage();
		prevStage=new Stage();
		
	}
	@FXML
	private void initialize()
	{
		mainApp=new Stage();
		prevStage=new Stage();
	}
	public void setMainStage(Stage stage) {
		this.mainApp=new Stage();
		this.mainApp=stage;
	}
	@FXML
	private void loadCustomerMenu()throws IOException
	{
		 Stage stage = new Stage();
	     stage.setTitle("Customer Menu");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/CustomerPage.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
	     this.mainApp.close();
     	 stage.show();
     	 Receptionist rc=loader.getController();
     	 rc.setPrevStage(stage);
	}
	@FXML
	private void loadLogin() throws IOException
	{
		 Stage stage = new Stage();
	     stage.setTitle("Login Menu");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/loginPage.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
      	 mainApp.close();
      	 stage.show();
      	 LoginPageController lpc=loader.getController();
     	 lpc.setMainStage(stage);
		 
	}
	public Stage getPrevStage() {
		return prevStage;
	}
	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
