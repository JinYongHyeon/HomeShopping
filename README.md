<H1>KOSTA203기 개인 미니 프로젝트 홈쇼핑</H1>

<ul>
  <li>기획 : 20년09월01일  
  <ul>
    <li>Class Diagram</li>
    <li>UseCase Diagram</li>
    <li>ERD(Entity Relationship Diagrma)</li>
  </ul> </li>
  <li>개발 : 20년09월02일
  <hr>
  <ol>
  	<li>프로젝트 생성 : MVC + SingleTon + Front Controller Design Pattern / DB TABLE CREATE / DB USER INSERT(임시 계정)</li>
  	<li>로그인폼(JSP)페이지 및 로그인 기능 구축
  		<ol>
  			<li>login Form안에 ID, PASSWORD 값을 WAS에 request 요청을 하여 Controller을 건너 DAO에 DB 작업을 하고 ID와 PASSWORD가 같으면 session을 통해 client 정보를 유지를 시켜주고 redirect로 index 이동 실패 시 forward방식으로 login페이지로 이동 후 로그인 실패 알림(alert)</li>
  		</ol>
  	</li>
  	<li>로그아웃  기능 구축
  		<ol>
  			<li>로그아웃 버튼 클릭 시 DispatcherServlet(FrontController)을 통해 HandleRequest에서 HandlerMapping(Factory)을 작동하여 로그아웃 컨트롤러 접근하여 session.invalidate()<-- 세션 무효화 처리 작업 후 redirect index 페이지 이동</li>
  		</ol>
  	</li>
  	<li>
  		유저리스트(JSP)페이지 및 유저리스트 기능 구축
  		<ol>
  			<li>관리자 계정으로 로그인 시 메인페이지(index)에 조건문을 통해 관리자페이지 링크표시, 관리자페이지(admin.jsp) 접근 시  관리자 세션 체크 및 아이디 체크, 유저정보 이벤트 작동 시  현재 존재하는 유저 DAO에서 SELECT 후 Controller을 통해 값 전달 후 admin페이지에 table에 값을 뿌려준다. </li>
  		</ol>
  	</li>
 	<li>
 	유저리스트 검색 기능 구축
  		<ol>
  			<li>관리자 페이지 유저검색을 할 시 PRIMARY KEY인 ID로 검색을 하여 존재하면 TABLE에 값을 뿌려주고 존재하지 않으면 회원이 존재하지 않는다 message을 TABLE에 뿌려준다.</li>
  		</ol>
  	</li>
  </ol>
  
  	
  </li>
  <li>개발 : 20년09월03일
  	<hr>
  	<ol>
  		<li>회원가입 : 이슈!! 아이디 중복체크(ajax 배우면 추가 예정 ing~) / 비밀번호 재확인 검사 작업(javascript 처리 완료)</li>
  		<li>개인정보 : SESSION에 클라이언트 정보를 가져와 개인정보 폼에 뿌려준다.</li>
  		<li>개인정보 수정 : SESSION에 클라이언트의  정보를 개인정보 수정폼에 뿌려주고 아이디를 제외한 나머지 폼에서 수정을 하고 싶은 폼을 수정 후 
  			SUBMIT을 통해 DAO작업을 하고 문제가 없을 시 SESSION에서 USER 정보를 재활당해서 개인정보를 재확인 할때 수정 된 정보를 확인 할 수 있도록
  			한다.
  		  </li>
  		<li>아이디 찾기 : 아이디찾기폼에서 이름과 이메일을 입력을 하여  DAO에서 DB작업을 할때 이름과 이메일이 둘다 동일한 ID를 가져와 아이디 찾기 폼에 ID를 뿌려주고 그렇지 않을경우 아이디 찾기 실패라는 알림을 보내준다.</li>
  	</ol>
  </li>
  <li>개발 : 20년09월05일
  <hr>
  	<ol>
  		<li>관리자페이지 상품리스트 : 관리자페이지에서 상품정보를 클릭 시 DAO에서 모든 상품정보를 가져와 관리자페이지 TABLE VIEW에 뿌려준다.</li>
  		<li>관리자페이지 상품검색 : 이슈!! 광범위한 검색기능 보충필요 : ex) 테스트* --> 테스트1, 테스트2... ~ing / 정확한 상품이름 검색시 그 상품에 대한 정보를 관리자페이지에 보여준다.  </li>
  		<li>관리자페이지 상품수정 : 이슈!! 상품메인 이미지 or 상품상세 내용 보충구현 필요 ~ ing / 상품수정폼에 데이터를 뿌려주기 위해 DAO에서 원하는 상품 NO를 검색 후 수정폼에다가 뿌려준 다음 NO를 제외한 상품이름 가격 수량 등 변경을 한다.</li>
  	</ol>
  </li>
  
  
</ul>

<h1>이슈!!</h1>
<h1> 스마트에디터 사용법 미숙 / MultipartRequest... getParameter(name) 값을 못 가죠옴... command값도 못가져와서 Controller Handle ERROR
Spring Framework 사용시 MultipartRequest 쉽게 사용가능 현재는 Servlet API 파일(COS) 파일 다운받아서 패키지 import해서 사용 현재 교육받은 스킬로는 부족 ... 결론 Project 잠정 보류...</h1>
