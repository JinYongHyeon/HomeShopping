package org.shopping.model;

public class OrderVO {
	private String orderNo;// 주문번호
	private String orderDate;// 주문날짜
	private String recipientName;// 받는사람
	private String recipientAddress;// 받는주소
	private String recipientTelephone;// 받는사람 연락처
	private UserVO userVO;

	public OrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderVO(String orderNo, String orderDate, String recipientName, String recipientAddress,
			String recipientTelephone, UserVO userVO) {
		super();
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.recipientName = recipientName;
		this.recipientAddress = recipientAddress;
		this.recipientTelephone = recipientTelephone;
		this.userVO = userVO;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getRecipientTelephone() {
		return recipientTelephone;
	}

	public void setRecipientTelephone(String recipientTelephone) {
		this.recipientTelephone = recipientTelephone;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	@Override
	public String toString() {
		return "OrderVO [orderNo=" + orderNo + ", orderDate=" + orderDate + ", recipientName=" + recipientName
				+ ", recipientAddress=" + recipientAddress + ", recipientTelephone=" + recipientTelephone + ", userVO="
				+ userVO + "]";
	}

}
