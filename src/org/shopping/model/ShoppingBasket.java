package org.shopping.model;

public class ShoppingBasket {
	private ProductVO productVO;
	private UserVO userVO;
	private int shoppingBasketCount;

	public ShoppingBasket() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public ShoppingBasket(ProductVO productVO, UserVO userVO, int shoppingBasketCount) {
		super();
		this.productVO = productVO;
		this.userVO = userVO;
		this.shoppingBasketCount = shoppingBasketCount;
	}

	


	public int getShoppingBasketCount() {
		return shoppingBasketCount;
	}



	public void setShoppingBasketCount(int shoppingBasketCount) {
		this.shoppingBasketCount = shoppingBasketCount;
	}



	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	@Override
	public String toString() {
		return "ShoppingBasket [productVO=" + productVO + ", userVO=" + userVO + "]";
	}


}
