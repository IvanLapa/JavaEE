package by.htp.les02.entity;

public class User {
	public static int people_counter;
	private String first_name;
	private String login;
	private String password;
	private String phone_number;
	private String political_view;
	
	public User () {
		System.out.println("We are already " + ++people_counter);
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public void setFirstName (String first_name) {
		this.first_name=first_name;
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
		return phone_number;
	}
	
	public void setPhoneNumder (String phone_number) {
		this.phone_number=phone_number;
	}
	public String getPoliticalView() {
		return political_view;
	}
	
	public void setPoliticalView (String political_view) {
		this.political_view=political_view;
	}
}
