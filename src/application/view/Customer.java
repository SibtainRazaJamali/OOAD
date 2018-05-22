package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Customer extends BorderPane
{
	@FXML 
	private int customerId;
	@FXML
	private String customerName;
	@FXML
	private long contactNumber;
	
	public Customer() 
	{
		
	}
	public Customer(String name,long number)
	{
		customerName=name;
		contactNumber=number;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	

}
