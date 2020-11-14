package org.shopping.model;

public class UserVO {
	private String id; //아이디
	private String password; //비밀번호
	private String name; //이름
	private String address; //주소
	private String telephone; //전화번호
	private String email; //이메일
	private int totalPurchase; //총 구매량

	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public UserVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}



	public UserVO(String id, String password, String name, String address, String telephone, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}


	public UserVO(String id, String password, String name, String address, String telephone, String email,
			int totalPurchase) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.totalPurchase = totalPurchase;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTotalPurchase() {
		return totalPurchase;
	}


	public void setTotalPurchase(int totalPurchase) {
		this.totalPurchase = totalPurchase;
	}
	

	
}
