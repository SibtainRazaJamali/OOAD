package application.view;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Driver {

	private String name;
	private int dId;
	private Bus assignedBus;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public Bus getAssignedBus() {
		return assignedBus;
	}
	public void setAssignedBus(Bus assignedBus) {
		this.assignedBus = assignedBus;
	}
	public Driver() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Driver(String text, int parseInt) {
		this.name=text;
		this.assignedBus=new Bus();
		this.assignedBus.setBusId(parseInt);
		
	}

















	@FXML
	private TextField driverName;
	@FXML
	private TextField busId;
	@FXML
	private Label driverAdded;
	@FXML
	private void addDriver()
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();  
		Transaction t=session.beginTransaction();  
	    Query query = session.createQuery("from Bus");
	    List<Bus> list = (List<Bus>)query.list();
	    Boolean isValid=false;
	    for(Bus b:list)
	    {
	    	if(b.getBusId()==Integer.parseInt(busId.getText()))
	    	{
	    		isValid=true;
	    	}
	    }
	    query = session.createQuery("from Driver");
	    List<Driver> list1 = (List<Driver>)query.list();
	    
	    for(Driver d:list1)
	    {
	    	if(d.getAssignedBus().getBusId()==Integer.parseInt(busId.getText()))
	    	{
	    		isValid=false;
	    	}
	    }
	    if(isValid)
	    {
	    	Driver newDriver=new Driver(driverName.getText(),Integer.parseInt(busId.getText()));
	    	session.persist(newDriver);
	    	t.commit();
	    	this.driverAdded.setText("Driver Successfully Assigned");
	    }
	    else
	    {
	    	this.driverAdded.setText("Invalid Bus ID");
	    	t.commit();
	    }
	    
	    if ( session.isOpen() ) session.close();
	}
	private Stage prevStage;
	@FXML
	private void previousMenu() throws IOException
	{
		Stage stage = new Stage();
	     stage.setTitle("Manager's Menu");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/ManagersMenu.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
	     stage.show();
	     this.prevStage.close();
	     setPrevStage(stage);
	     Manager mc=loader.getController();
		 mc.setPrevStage(stage);
	}
	public Stage getPrevStage() {
		return prevStage;
	}
	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}
	
}
