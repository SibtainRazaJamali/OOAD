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

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Route 
{

	private int routeId;
	private String source;
	private String destination;
	private double fare;
	public int getRouteId() 
	{
		return routeId;
	}
	public void setRouteId(int routeId) 
	{
		this.routeId = routeId;
	}
	
	public String getSource() 
	{
		return source;
	}
	public void setSource(String source) 
	{
		this.source = source;
	}
	public String getDestination() 
	{
		return destination;
	}
	public void setDestination(String destination) 
	{
		this.destination = destination;
	}
	
	
	@FXML
	private TextField sourceCity;
	@FXML
	private TextField destinationCity;
	@FXML
	private Label routeAdded;
	@FXML
	private TextField fareCost;
	private Stage prevStage;
	@FXML
	private TextArea availableRoutes;
	public Route() 
	{
		
	}
	@FXML
	private void availableRoute()
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();  
		Transaction t=session.beginTransaction();  
	    Query query = session.createQuery("from Route");
		List<Route> list = (List<Route>)query.list();
		availableRoutes.setEditable(true);
		
		availableRoutes.setText("Route Id\t\tDeparture\t\t\tArrival\t\t\t\tFare(Rs)");
		for(Route l : list ) 
		{ 
			availableRoutes.setText(availableRoutes.getText()+"\n"+l.getRouteId()+"\t\t\t"+l.getSource()+
					"\t\t\t"+l.getDestination()+"\t\t\t"+l.getFare());
		}
		availableRoutes.setEditable(false);
		t.commit();
		if ( session.isOpen() ) session.close();
		
	}
	public Route(String Source,String Destination)
	{
		this.destination=Destination;
		this.source=Source;
	}
	
	@FXML
	private void makeRoute()
	{
		String temp=fareCost.getText().toString();
		Boolean hasLetters=false;
		Boolean flag=false;
		for(char c:temp.toCharArray())
		{
			if(Character.isLetter(c))
			{
				hasLetters=true;
				break;
			}
		}
		if(hasLetters)
		{
			flag=false;
		}
		else
		{
			flag=true;
		}
		if(flag==true)
		{
			Route newRoute=new Route(sourceCity.getText().toString(),destinationCity.getText().toString());
			newRoute.setFare(Double.parseDouble(fareCost.getText().toString()));
			SessionFactory factory=HibernateUtil.getSessionFactory();
			Session session=factory.openSession();  
			Transaction t=session.beginTransaction();  
		    
			Query query = session.createQuery("from Route");
			// query.list() returns objects, cast to List<Location>
			List<Route> list = (List<Route>)query.list( );
			
			Boolean searched=false;
			if(sourceCity.getText().toString().equals(destinationCity.getText().toString()))
		    {
		    	searched=true;
		    }
			for(Route l : list ) 
			{ 
				if(l.getSource().equals(sourceCity.getText().toString()) && l.getDestination().equals(destinationCity.getText().toString()))
				{
					searched=true;
					
				}
			}
			if(searched)
		    {
		    	routeAdded.setText("Invalid Route Info");
		    }
		    else
		    {
		    	session.persist(newRoute);
		    	t.commit();
		    	routeAdded.setText("Route Created");
		    	
		    }
			if ( session.isOpen() ) session.close();
		    
		}
		else
		{
			routeAdded.setText("Invalid Route Info");
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
	public void setPrevStage(Stage stage) {
		// TODO Auto-generated method stub
		this.prevStage=stage;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	
	

}
