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
		if (command.equals("productCounting")) {
			controller = new ProductCountingController(); //상품수량체크 변경 및 체크
		} else if (command.equals("productDelete")) {
			controller = new ProductDeleteController(); //상품삭제
		} else if (command.equals("productUpdate")) {
			controller = new ProductUpdateController(); //상품수정
		} else if (command.equals("productInsert")) {
			controller = new ProductInsertController();//상품추가
		} else if (command.equals("ProductFindByList")) {
			controller = new ProductFindByListController();//상품검색
		} else if (command.equals("productList")) {
			controller = new ProductListController();//상품전체검색
		} else if (command.equals("usersingUp")) {
			controller = new UserSingUpController();//회원가입
		} else if (command.equals("userImformationUpdate")) {
			controller = new UserImformationUpdateController();//개인정보 수정
		} else if (command.equals("userFindById")) {
			controller = new UserFindByIdController();//아이디찾기
		} else if (command.equals("userFindByPass")) {
			controller = new UserFindByPasswordController();//비밀번호 찾기
		} else if (command.equals("userImformation")) {
			controller = new UserImformationController();//내정보
		}else if(command.equals("userProductBuyRecord")) {
			controller = new UserProductBuyRecordController();//구매내역
		}else if(command.equals("userLogin")) {
			controller = new UserLoginController();//로그인
		}else if(command.equals("userLogout")) {
			controller = new UserLogoutController();//로그아웃
		}else if(command.equals("userList")) {
			controller = new UserListController();//유저리스트
		}else if(command.equals("userFindByList")) {
			controller = new UserFindByList();
		}
		return controller;
	}
}
