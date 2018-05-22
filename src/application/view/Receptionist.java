package application.view;

import java.io.IOException;

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

public class Receptionist  
{

	private int receptionistId;
	private String receptionistName;
	private String loginPassword;
	private Terminal position;
	public String getReceptionistName() {
		return receptionistName;
	}
	public void setReceptionistName(String receptionistName) {
		this.receptionistName = receptionistName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public int getReceptionistId() {
		return receptionistId;
	}
	public void setReceptionistId(int receptionistId) {
		this.receptionistId = receptionistId;
	}
	
	
	public Receptionist() 
	{
		// TODO Auto-generated constructor stub
	}
	public Receptionist(String Name,String Password)
	{
		this.receptionistName=Name;
		this.loginPassword=Password;
	}
	
	@FXML
	private TextField cid;
	@FXML
	private TextField cname;
	@FXML
	private TextField cmobile;
	@FXML
	private void reserveBus() throws IOException
	{
		 Stage stage = new Stage();
	     stage.setTitle("Bus Seat Reservation");
	     BorderPane root = new BorderPane();
		 FXMLLoader loader=new FXMLLoader();
		 loader.setLocation(Main.class.getResource("view/BusReservation.fxml"));
	     root=(BorderPane)loader.load();
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
	     this.prevStage.close();
	     stage.show();
	     this.setPrevStage(stage);
	     Reservation rc=loader.getController();
	     rc.setPrevStage(stage);
		
	}
	@FXML
	private Label employeeAdded;
	@FXML
	private TextField receptName;
	@FXML
	private TextField receptPass;
	@FXML
	private TextField tLocation;
	@FXML
	private void assignReceptionist()
	{
		Terminal newTerminal=new Terminal(tLocation.getText());
		Receptionist newEmployee=new Receptionist(receptName.getText(),receptPass.getText());
		
		newEmployee.setPosition(newTerminal);
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();  
		Transaction t=session.beginTransaction();  
		session.persist(newEmployee);
    	t.commit();
    	employeeAdded.setText("Employee Added");
    	if ( session.isOpen() ) session.close();
	}
	private Stage prevStage;
	@FXML
	private void prevMenu() throws IOException
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
	public Terminal getPosition() {
		return position;
	}
	public void setPosition(Terminal position) {
		this.position = position;
	}
	public Stage getPrevStage() {
		return prevStage;
	}
	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}
}
