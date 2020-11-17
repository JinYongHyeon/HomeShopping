package org.shopping.controller;

public class HandlerMapping {
	
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		return instance;
	}

	/**
	 * 컨트롤러 객체 생성하는 공장(Factory)
	 * @param command
	 * @return
	 */
	public Controller create(String command) {
		Controller controller = null;
	if(command.equals("home")) {//메인페이지
		controller = new HomeController(); 
	}else if (command.equals("productCounting")) {//상품수량체크 변경 및 체크
			controller = new ProductCountingController(); 
		} else if (command.equals("productDelete")) {//상품삭제
			controller = new ProductDeleteController(); 
		}else if(command.equals("productUpdateForm")) {//상품수정폼
			controller = new ProductUpdateFormController();
		} else if (command.equals("productUpdate")) {//상품수정
			controller = new ProductUpdateController(); 
		}else if(command.equals("productInsertForm")) {//상품추가 폼
			controller = new ProductInsertFormController();			
		} else if (command.equals("productFindByList")) {//상품검색(어드민)
			controller = new ProductFindByListController();
		} else if (command.equals("productList")) {//상품전체검색
			controller = new ProductListController();
		}else if(command.equals("userSingUpForm")) {//회원가입 폼
			controller = new UserSingUpFormController();
		} else if (command.equals("usersingUp")) {//회원가입
			controller = new UserSingUpController();
		}else if(command.equals("userImformationFrom")) {//개인정보 폼
			controller = new UserImformationFormController();
		}else if(command.equals("userImformationUpdateForm")) {//개인정보 수정 폼
			controller = new UserImformationUpdateFormController();
		} else if (command.equals("userImformationUpdate")) {//개인정보 수정
			controller = new UserImformationUpdateController();
		} else if(command.equals("userProductBuyRecord")) {//구매내역
			controller = new UserProductBuyRecordController();
		} else if(command.equals("userLoginForm")) {//로그인 폼
			controller = new UserLoginFormController(); 
		}else if(command.equals("userLogin")) {//로그인
			controller = new UserLoginController();
		}else if(command.equals("userLogout")) {//로그아웃
			controller = new UserLogoutController();
		}else if(command.equals("userList")) {//유저리스트
			controller = new UserListController();
		}else if(command.equals("userFindByList")) {//유저검색
			controller = new UserFindByList();
		}else if(command.equals("productDetail")) {// 상세페이지
			controller = new ProductDetailController();
		}else if(command.equals("userIdCheck")) {
			controller = new UserIdCheckController();
		}else if(command.equals("productKindList")) { //상품종류별 리스트
			controller = new ProductKindListController();
		}else if(command.equals("userProductFindByList")) {//사용자 상품 검색
			controller = new UserProductFindByListController();
		}else if(command.equals("productAddCart")) {//장바구니 추가
			controller = new ProductAddCartController();
		}else if(command.equals("productCartList")) {//장바구니 리스트
			controller = new ProductCartListController();
		}else if(command.equals("productDeleteCart")) {//장바구니 삭제
			controller = new ProductDeleteCartController();
		}
		return controller;
	}
}
