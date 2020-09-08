package org.shopping.model;

public class ProductVO {
	private String no; // 상품번호
	private String name; // 상품이름
	private int price; // 상품가격
	private String content; // 상품 상세내용
	private String imgPath; // 메인이미지 주소
	private int count; // 재고
	private String kinds; // 상품종류
	private String productNew; // 신상유무체큰
	private String date; //등록일

	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ProductVO(String name, int price, String content, String imgPath, int count, String kinds,
			String productNew) {
		super();
		this.name = name;
		this.price = price;
		this.content = content;
		this.imgPath = imgPath;
		this.count = count;
		this.kinds = kinds;
		this.productNew = productNew;
	}


	public ProductVO(String no, String name, int price, String imgPath, int count, String kinds, String productNew,
			String date) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.imgPath = imgPath;
		this.count = count;
		this.kinds = kinds;
		this.productNew = productNew;
		this.date = date;
	}
		
	

	public ProductVO(String no, String name, int price, String imgPath, int count, String kinds, String productNew) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.imgPath = imgPath;
		this.count = count;
		this.kinds = kinds;
		this.productNew = productNew;
	}


	public ProductVO(String no, String name, int price, String content, String imgPath, int count, String kinds,
			String productNew, String date) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.content = content;
		this.imgPath = imgPath;
		this.count = count;
		this.kinds = kinds;
		this.productNew = productNew;
		this.date = date;
	}


	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public String getProductNew() {
		return productNew;
	}

	public void setProductNew(String productNew) {
		this.productNew = productNew;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
}
