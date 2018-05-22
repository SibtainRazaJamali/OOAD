package application.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Bus 
{

	
	private int busId;
	private String departureTime;
	private List<Integer> seats;
	private Route route;
	

	public Bus() 
	{
		route=new Route();
		seats=new ArrayList<Integer>(30);
		for(int i=1;i<=30;i++)
		{
			seats.add(i);
		}
	}
	
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	
	
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}

	

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public List<Integer> getSeats() {
		return seats;
	}

	public void setSeats(List<Integer> seats) {
		this.seats = seats;
	}
	
	public Stage getPrevStage() {
		return prevStage;
	}

	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}
	@FXML
	private Label routeAssigned;
	@FXML
	private TextField routeId;
	@FXML
	private TextField departureInfo;
	
	@FXML
	private void assignRoute()
	{
		Bus newBus=new Bus();
		if(newBus.busRoute(Integer.parseInt(routeId.getText().toString()),departureInfo.getText().toString()))
		{
			routeAssigned.setText("Route Successfully Assigned");
		}
		else
		{
			routeAssigned.setText("Not a valid Route Info");
		}
	}
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
	@FXML
	private TextArea showlist;
	@FXML
	private void viewBuses()
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();  
		Transaction t=session.beginTransaction();  
	    Query query = session.createQuery("from Bus");
	    List<Bus> list = (List<Bus>)query.list();
	    for(Bus b:list)
	    {
	    	showlist.setText(showlist.getText()+b.getBusId()+"\t  "+b.getDepartureTime()
	    	+"\t  "+b.getRoute().getSource()+"\t\t   "+b.getRoute().getDestination()+"\t "+b.getRoute().getFare()+"\n");
	    }
	    showlist.setEditable(false);
	    t.commit();
	    if ( session.isOpen() ) session.close();
	    
	}
	public Boolean busRoute(int routeId,String time)
	{
		
		if(time.equals("09:00-AM") || time.equals("12:00-AM") || time.equals("03:00-AM") ||
		   time.equals("06:00-AM") || time.equals("09:00-PM") || time.equals("12:00-PM") ||
		   time.equals("03:00-PM") || time.equals("06:00-PM"))
		{
			Boolean isValid=false;
			this.setDepartureTime(time);
			this.route.setRouteId(routeId);
			SessionFactory factory=HibernateUtil.getSessionFactory();
			Session session=factory.openSession();  
			Transaction t=session.beginTransaction();
			Query query = session.createQuery("from Bus");
		    List<Bus> list = (List<Bus>)query.list();
		    for(Bus b:list)
		    {
		    	if(b.route.getRouteId()==routeId)
		    	{
		    		isValid=true;
		    	}
		    }
		    if(!isValid)
		    {
		    	Bus myBus=new Bus();
				myBus=this;
				session.persist(myBus);
		    	t.commit();
		    	if ( session.isOpen() ) session.close();
		    	return true;
		    }
			
	    	
		}
		return false;
			
	}
	
	private Stage prevStage;
	
	
}
