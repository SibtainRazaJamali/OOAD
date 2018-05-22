package application.view;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Manager 
{

	
	private String userName="admin";
	
	private String password="admin";
	
	private Stage prevStage;
	
	public Manager() 
	{
		
	}
	public Boolean managerLogin(String Id,String pass)
	{
		if(userName.equals(Id) && password.equals(pass))
		{
			return true;
		}
		return false;
	}
	public static Manager createObject()
	{
		return new Manager();
	}
	
	
	public void setPrevStage(Stage stage) {
		this.prevStage=stage;
		
	}
	@FXML
	private void addReceptionist() throws IOException
	{
		 Stage stage = new Stage();
	     stage.setTitle("Adding New Receptionist");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/AssignReceptionist.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
	     this.prevStage.close();
    	 stage.show();
    	 Receptionist rc=loader.getController();
    	 rc.setPrevStage(stage);
	}
	@FXML
	private void viewRoutes() throws IOException
	{
		 Stage stage = new Stage();
	     stage.setTitle("View Route");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/AvailableRoute.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
	     this.prevStage.close();
    	 stage.show();
    	 Route rc=loader.getController();
    	 rc.setPrevStage(stage);
	}
	
	
	@FXML
	private void assignBusRoute() throws IOException
	{
		Stage stage = new Stage();
	     stage.setTitle("Assign Bus Route");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/AssignRoute.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
	     this.prevStage.close();
    	 stage.show();
    	 this.setPrevStage(stage);
    	 Bus bc=loader.getController();
	     bc.setPrevStage(stage);
	}
	@FXML
	private void assignDriverToBus() throws IOException
	{
		Stage stage = new Stage();
	     stage.setTitle("Assign Duties to Driver");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/DriverDuty.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
	     this.prevStage.close();
    	 stage.show();
    	 this.setPrevStage(stage);
    	 Driver dc=loader.getController();
	     dc.setPrevStage(stage);
	}
	@FXML
	private void viewBuses() throws IOException
	{
		Stage stage = new Stage();
	     stage.setTitle("View Buses");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/ViewBus.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
	     this.prevStage.close();
	     stage.show();
	     Bus bc=loader.getController();
	     bc.setPrevStage(stage);
	}
	@FXML
	private void newRoute() throws IOException
	{
		 Stage stage = new Stage();
	     stage.setTitle("New Route");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/RouteView.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
	     this.prevStage.close();
     	 stage.show();
     	 Route rc=loader.getController();
     	 rc.setPrevStage(stage);
     }
	@FXML
	private void prevMenu() throws IOException
	{
		 Stage stage = new Stage();
	     stage.setTitle("Daewoo Service Management System");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/FirstPage.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
    	 stage.show();
		 this.prevStage.close();
		 setPrevStage(stage);
		 FirstPageController fpc=loader.getController();
		 fpc.setMainStage(stage);
	}
	
	

}
