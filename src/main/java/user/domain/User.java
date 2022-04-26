package user.domain;

/**
 * User object
 * @author Aayush Makharia
 */
public class User {
	/*
	 * Correspond to the user table
	 */
	
	private String username;
	private String password; 
	private String name;
	private String uid;
	

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "User [ uid=" + uid +", name=" + name + ", username="
				+ username + ", password=" + password +"]";
	}
}
