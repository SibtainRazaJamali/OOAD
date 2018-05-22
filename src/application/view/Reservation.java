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

public class Reservation 
{

	public Reservation()
	{
		
	}
	
	@FXML
	private TextField seatNo;
	@FXML
	private TextField bId;
	@FXML
	private Label availableBuses;
	@FXML
	private TextArea validId;
	@FXML
	private Label validSeats;
	@FXML
	private void setSeat()
	{
		
	}
	@FXML
	private void viewSeats()
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();  
		Transaction t=session.beginTransaction();  
	    Query query = session.createQuery("from Bus");
	    List<Bus> list = (List<Bus>)query.list();
	    for(Bus b:list)
	    {
	    	
	    	if(b.getBusId()==this.busId)
	    	{
	    		
	    		for(int i=1;i<=b.getSeats().size();i++)
	    		{
	    			validSeats.setText(validSeats.getText()+b.getSeats().get(i-1)+"\t\t");
	    			if(i%5==0)
	    			{
	    				validSeats.setText(validSeats.getText()+"\n");
	    			}
	    		}
	    	}
	    }
	   
	    t.commit();
	    if ( session.isOpen() ) session.close();
	}
	@FXML
	private void viewBus()
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();  
		Transaction t=session.beginTransaction();  
	    Query query = session.createQuery("from Bus");
	    List<Bus> list = (List<Bus>)query.list();
	    for(Bus b:list)
	    {
	    	availableBuses.setText(availableBuses.getText()+b.getBusId()+"\t  "+b.getDepartureTime()
	    	+"\t  "+b.getRoute().getSource()+"\t\t   "+b.getRoute().getDestination()+"\t "+b.getRoute().getFare()+"\n");
	    }
	   
	    t.commit();
	    if ( session.isOpen() ) session.close();
	}
	private int busId;
	@FXML
	private void next() throws IOException
	{
		String temp=bId.getText().toString();
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
		if(flag)
		{
			SessionFactory factory=HibernateUtil.getSessionFactory();
			Session session=factory.openSession();  
			Transaction t=session.beginTransaction();  
		    Query query = session.createQuery("from Bus");
		    List<Bus> list = (List<Bus>)query.list();
		    Boolean isValid=false;
		    for(Bus b:list)
		    {
		    	if(b.getBusId()==Integer.parseInt(bId.getText().toString()))
		    	{
		    		isValid=true;
		    	}
		    }
		    
		    if(!isValid)
		    {
		    	validId.setText("Invalid Bus Id");
		    }
		    else
		    {
		    	
		    	validId.setText("Bus Id Verified");
		    	 Stage stage = new Stage();
			     stage.setTitle("Adding New Receptionist");
			     BorderPane root = new BorderPane();
				 FXMLLoader loader=new FXMLLoader();
				 loader.setLocation(Main.class.getResource("view/seats.fxml"));
			     root=(BorderPane)loader.load();
			     Scene scene = new Scene(root);
			     stage.setScene(scene);
			     this.prevStage.close();
			     this.setBusId(Integer.parseInt(bId.getText()));
		    	 stage.show();
		    	 this.setPrevStage(stage);
		    	 Reservation rc=loader.getController();
		    	 rc.setBusId(busId);
		    	 
		    	
		    }
		    t.commit();
		    if ( session.isOpen() ) session.close();
		}
		else
		{
			validId.setText("Invalid Bus Id");
		}
		
	}
	public Stage getPrevStage() {
		return prevStage;
	}
	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	private Stage prevStage;
	

}
