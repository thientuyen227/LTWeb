package vn.iotstar.model;

public class user extends AbstractModel<user> {
	private String firstname;
	private String lastname;
	private String id_card;
	private String email;
	private String phone;
	private boolean isEmailActive;
	private boolean isPhoneActive;
	private String password;
	private String role;
	private String avatar;
	private double eWallet;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEmailActive() {
		return isEmailActive;
	}
	public void setEmailActive(boolean isEmailActive) {
		this.isEmailActive = isEmailActive;
	}
	public boolean isPhoneActive() {
		return isPhoneActive;
	}
	public void setPhoneActive(boolean isPhoneActive) {
		this.isPhoneActive = isPhoneActive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public double geteWallet() {
		return eWallet;
	}
	public void seteWallet(double eWallet) {
		this.eWallet = eWallet;
	}
	
}
