package org.shopping.model;

public class ShoppingBasket {
	private int shoppingBasketCount;// 제품 수량(장바구니)
	private int shoppingBasketPrice;// 제품 가격(장바구니)
	private ProductVO productVO;
	private UserVO userVO;

	public ShoppingBasket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoppingBasket(int shoppingBasketCount, int shoppingBasketPrice, ProductVO productVO, UserVO userVO) {
		super();
		this.shoppingBasketCount = shoppingBasketCount;
		this.shoppingBasketPrice = shoppingBasketPrice;
		this.productVO = productVO;
		this.userVO = userVO;
	}

	public int getShoppingBasketCount() {
		return shoppingBasketCount;
	}

	public void setShoppingBasketCount(int shoppingBasketCount) {
		this.shoppingBasketCount = shoppingBasketCount;
	}

	public int getShoppingBasketPrice() {
		return shoppingBasketPrice;
	}

	public void setShoppingBasketPrice(int shoppingBasketPrice) {
		this.shoppingBasketPrice = shoppingBasketPrice;
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
		return "ShoppingBasket [shoppingBasketCount=" + shoppingBasketCount + ", shoppingBasketPrice="
				+ shoppingBasketPrice + ", productVO=" + productVO + ", userVO=" + userVO + "]";
	}

}
