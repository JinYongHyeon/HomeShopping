package org.shopping.model;

public class OrderDetailVO {
	private int orderCount;// 주문 수량
	private int orderPrice;// 주문 금액
	private OrderVO orderVO;
	private ProductVO productVO;

	public OrderDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailVO(int orderCount, int orderPrice, OrderVO orderVO, ProductVO productVO) {
		super();
		this.orderCount = orderCount;
		this.orderPrice = orderPrice;
		this.orderVO = orderVO;
		this.productVO = productVO;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public OrderVO getOrderVO() {
		return orderVO;
	}

	public void setOrderVO(OrderVO orderVO) {
		this.orderVO = orderVO;
	}

	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	@Override
	public String toString() {
		return "OrderDetailVO [orderCount=" + orderCount + ", orderPrice=" + orderPrice + ", orderVO=" + orderVO
				+ ", productVO=" + productVO + "]";
	}

}
