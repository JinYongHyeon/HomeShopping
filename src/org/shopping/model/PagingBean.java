package org.shopping.model;

public class PagingBean {
	private int nowPage = 1;
	private int totalRow;
	private int postCountPrePage;//페이지 당 게시물 수
	private int pageCountPerPageGroup;//그룹 당 페이지 수
		
	
	
	public PagingBean(int totalRow, int postCountPrePage, int pageCountPerPageGroup) {
		super();
		this.totalRow = totalRow;
		this.postCountPrePage = postCountPrePage;
		this.pageCountPerPageGroup = pageCountPerPageGroup;
	}

	public PagingBean(int nowPage, int totalRow, int postCountPrePage, int pageCountPerPageGroup) {
		super();
		this.nowPage = nowPage;
		this.totalRow = totalRow;
		this.postCountPrePage = postCountPrePage;
		this.pageCountPerPageGroup = pageCountPerPageGroup;
	}

	//페이지 게시물 시작번호
	public int getStartPageRow() {
		return (nowPage-1)*postCountPrePage+1;
	}
	//페이지 게시물 끝번호
	public int getEndPageRow() {
		return nowPage*postCountPrePage>totalRow?totalRow:nowPage*postCountPrePage;
	}
	//총페이지
	public int getTotalPage() {
		return totalRow%postCountPrePage==0?totalRow/postCountPrePage:totalRow/postCountPrePage+1;
	}
	//총 그룹
	public int getTotalGroup() {
		return getTotalPage()%pageCountPerPageGroup==0?getTotalPage()/pageCountPerPageGroup:getTotalPage()/pageCountPerPageGroup+1;
	}
	//현재 그룹
	public int getNowGroup() {
		return nowPage%pageCountPerPageGroup==0?nowPage/pageCountPerPageGroup:nowPage/pageCountPerPageGroup+1;
	}
	//그룹 시작 페이지 번호
	public int getStartGroup() {
		return (getNowGroup()-1)*pageCountPerPageGroup+1;
	}
	//그룹 끝 페이지 번호
	public int getEndGroup() {
		return getNowGroup()*pageCountPerPageGroup>getTotalPage()?getTotalPage():getNowGroup()*pageCountPerPageGroup;
	}
	//previous
	public boolean isPreviousPageGroup() {
		return getNowGroup()>1?true:false;
	}
	//next 
	public boolean isNextPageGroup() {
		return getNowGroup()<getTotalGroup()?true:false;
	}
	
	public static void main(String[] args) {
			  PagingBean p = new PagingBean(10,47,5,4);
			  // 현페이지의 시작 row number 를 조회 46
			  System.out.println("getBeginRowNumber:" + p.getStartPageRow());
			  // 현페이지의 마지막 row number 를 조회 47
			  System.out.println("getEndRowNumber:" + p.getEndPageRow());
			  // 전체 페이지 수 : 10
			  System.out.println("getTotalPage:" + p.getTotalPage());
			  // 전체 페이지 그룹 수 : 3
			  System.out.println("getTotalPageGroup:" + p.getTotalGroup());
			  System.out.println("////////////////////////////");
			  p = new PagingBean(6,31,5,4);// 게시물수 31 현재 페이지 6
			  // 현페이지의 시작 row number 를 조회 26
			  System.out.println("getStartRowNumber:" + p.getStartPageRow());
			  // 현페이지의 마지막 row number 를 조회 30
			  System.out.println("getEndRowNumber:" + p.getEndPageRow());
			  // 게시물수 31 -> 총페이지수 7 -> 총페이지그룹->2
			 // 현재 페이지 그룹 : 2
			  System.out.println("getNowPageGroup:" + p.getNowGroup());
			  // 페이지 그룹의 시작 페이지 : 5
			  System.out.println("getStartPageOfPageGroup:" + p.getStartGroup());
			   // 페이지 그룹의 마지막 페이지 : 7
			  System.out.println("getEndPageOfPageGroup:" + p.getEndGroup());
			  // 이전 페이지 그룹이 있는 지 : true
			  System.out.println("isPreviousPageGroup:" + p.isPreviousPageGroup());
			  // 다음 페이지 그룹이 있는 지 : false
			  System.out.println("isNextPageGroup:" + p.isNextPageGroup());
			  }
	

	
	
}
