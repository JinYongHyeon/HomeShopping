package org.shopping.model;

public class UserVO {
	private String id;
	private String password;
	private String name;
	private String tel;
	private String address;
	private String email;
	private int totalBuy;

	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public UserVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	

	public UserVO(String id, String password, String name, String tel, String address, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.email = email;
	}


	public UserVO(String id, String password, String name, String tel, String address, String email, int totalBuy) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.totalBuy = totalBuy;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTotalBuy() {
		return totalBuy;
	}

	public void setTotalBuy(int totalBuy) {
		this.totalBuy = totalBuy;
	}

}
