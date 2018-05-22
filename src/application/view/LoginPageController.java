package application.view;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.view.Manager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginPageController implements Initializable 
{
	@FXML
	private Stage prevStage;
	@FXML 
	private Stage mainApp;
	@FXML
	private TextField userName;
	@FXML
	private TextField password;
	@FXML
	private Label loggedIn;
	@FXML
	private Button next;
	private Manager administrator;
	public LoginPageController() 
	{
		mainApp=new Stage();
		administrator=Manager.createObject();
	}
	@FXML
	private void initialize()
	{
		mainApp=new Stage();
	}
	@FXML
	private void previousMenu() throws IOException
	{
	  	 Stage stage = new Stage();
	     stage.setTitle("Daewoo Service Management System");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/FirstPage.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
     	 mainApp.close();
		 stage.show();
		 setPrevStage(stage);
		 FirstPageController fpc=loader.getController();
		 fpc.setMainStage(stage);
	
		
			
	}
	@FXML
	private void nextMenu() throws IOException
	{
		Stage stage = new Stage();
	     stage.setTitle("Manager's Menu");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/ManagersMenu.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
    	 mainApp.close();
		 stage.show();
		 Manager mc=loader.getController();
		 mc.setPrevStage(stage);
		 
	}
	public void setMainStage(Stage stage) {
		this.mainApp=new Stage();
		this.mainApp=stage;
	}
	public void setPrevStage(Stage prevStag)
	{
		this.prevStage=prevStag;
	}
	@FXML
	private void checkLogin() throws IOException
	{
		if(administrator.managerLogin(userName.getText().toString(),password.getText().toString()))
		{
			loggedIn.setText("login Successfull");
			next.setDisable(false);
			next.setVisible(true);
			System.out.println("Check Login");
		}
		else
		{
			loggedIn.setText("login Failed");
		}
		 
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

