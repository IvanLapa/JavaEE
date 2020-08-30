package by.htp.les02.entity;

public class User {
	
	private String firstName;
	private String login;
	private String password;
	private String phoneNumber;
	private String politicalView;
	
	public User () {
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName (String first_name) {
		this.firstName=first_name;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin (String login) {
		this.login=login;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword (String password) {
		this.password=password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumder (String phone_number) {
		this.phoneNumber=phone_number;
	}
	public String getPoliticalView() {
		return politicalView;
	}
	
	public void setPoliticalView (String political_view) {
		this.politicalView=political_view;
	}
}
