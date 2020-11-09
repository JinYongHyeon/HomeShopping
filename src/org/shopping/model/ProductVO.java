package org.shopping.model;

public class ProductVO {
	private String productNo; // 상품번호
	private String productName; // 상품이름
	private int productPrice; // 상품가격
	private String productContent; // 상품 상세내용
	private String productMainImg; // 메인이미지 주소
	private int productPossesionCount; // 재고
	private String productDate; // 등록일
	private int productTotalSale;// 상품판매량

	public ProductVO() {
		super();
	}

	public ProductVO(String productNo, String productName, int productPrice, String productContent,
			String productMainImg, int productPossesionCount, String productDate, int productTotalSale) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productContent = productContent;
		this.productMainImg = productMainImg;
		this.productPossesionCount = productPossesionCount;
		this.productDate = productDate;
		this.productTotalSale = productTotalSale;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public String getProductMainImg() {
		return productMainImg;
	}

	public void setProductMainImg(String productMainImg) {
		this.productMainImg = productMainImg;
	}

	public int getProductPossesionCount() {
		return productPossesionCount;
	}

	public void setProductPossesionCount(int productPossesionCount) {
		this.productPossesionCount = productPossesionCount;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public int getProductTotalSale() {
		return productTotalSale;
	}

	public void setProductTotalSale(int productTotalSale) {
		this.productTotalSale = productTotalSale;
	}

	@Override
	public String toString() {
		return "ProductVO [productNo=" + productNo + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productContent=" + productContent + ", productMainImg=" + productMainImg
				+ ", productPossesionCount=" + productPossesionCount + ", ProductDate=" + productDate
				+ ", productTotalSale=" + productTotalSale + "]";
	}

	
}
