package manages.jdbc;

public class Manager {
	 private String id;
	 private String name;
	 private String identity;
	 private String phone;
	 private String password;
	public String getId() {
		return id;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public Manager(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", identity="
				+ identity + ", phone=" + phone + ", password=" + password
				+ "]";
	}
	 
}
