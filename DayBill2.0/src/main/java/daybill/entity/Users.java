package daybill.entity;

public class Users {
	private String username;
	private String password;
	private String sex;
	private String email;
	
	public Users() {
		super();
	}
	public Users(String userName, String password, String sex, String email) {
		super();
		this.username = userName;
		this.password = password;
		this.sex = sex;
		this.email = email;
	}
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
