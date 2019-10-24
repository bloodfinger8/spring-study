package board.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BoardPaging {
	private int currentPage; //현재 페이지
	private int pageBlock; //[이전][1][2][3][다음]
	private int pageSize; //1페이지당 5개
	private int totalA; //총 글수
	private StringBuffer pagingHTML;
	
	
	public void makePagingHTML() { //[1][2][3][다음] or [이전][4][5][6][다음] or [이전][7][8]
		pagingHTML = new StringBuffer();
		
		//총 페이지수
		int totalP = (totalA+pageSize-1)/pageSize;
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		//currentP  2 -> [1]
		//currentP  6 -> [4]
		//currentP  7 -> [7]
		int endPage = startPage + pageBlock -1;
		if(endPage > totalP) {
			endPage = totalP;
		}
		
		if(startPage>pageBlock) {
			pagingHTML.append("[<a id='paging' href='boardList.do?pg=" +(startPage-1)+"'>이전</a>]");
		}
		for(int i =startPage; i<=endPage; i++) {
			if(i == currentPage) {
				pagingHTML.append("[<a id='currentPaging' href='boardList.do?pg="+i+"'>"+ i + "</a>]");
			}else {
				pagingHTML.append("[<a id='paging' href='boardList.do?pg="+i+"'>"+ i + "</a>]");
			}
		}
		if(endPage < totalP) {
			pagingHTML.append("[<a id='paging' href='boardList.do?pg=" +(endPage+1)+"'>다음</a>]");
		}
	}
	
	public void makeSearchPagingHTML() { //[1][2][3][다음] or [이전][4][5][6][다음] or [이전][7][8]
		pagingHTML = new StringBuffer();
		
		//총 페이지수
		int totalP = (totalA+pageSize-1)/pageSize;
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		//currentP  2 -> [1]
		//currentP  6 -> [4]
		//currentP  7 -> [7]
		int endPage = startPage + pageBlock -1;
		if(endPage > totalP) {
			endPage = totalP;
		}
		
		if(startPage>pageBlock) {
			pagingHTML.append("[<a href='#' id='paging' onclick='boardSearch("+(startPage-1)+")'>이전</a>]");
		}
		for(int i =startPage; i<=endPage; i++) {
			if(i == currentPage) {
				pagingHTML.append("[<a href='#' id='currentPaging' onclick='boardSearch.do?pg="+i+"'>"+ i + "</a>]");
			}else {
				pagingHTML.append("[<a href='#' id='paging' onclick='boardSearch("+i+")'>"+ i + "</a>]");
			}
		}
		if(endPage < totalP) {
			pagingHTML.append("[<a href='#' id='paging' onclick='boardSearch("+(endPage+1)+")'>다음</a>]");
		}
	}
}

//String- 편집불가
//StringBuffer / StringBuilder - 편집가능
