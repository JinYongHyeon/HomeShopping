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
  		<li>개인정보 : SESSION에 계정 유지 정보를 가져와 개인정보 폼에 뿌려준다.</li>
  		<li>개인정보 수정 : </li>
  		<li>아이디 찾기</li>
  	</ol>
  </li>
  
  
</ul>
