package application.view;

public class Terminal
{

	private int tId;
	private String location;
	public Terminal() {
		// TODO Auto-generated constructor stub
	}
	public Terminal(String t)
	{
		location=t;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
