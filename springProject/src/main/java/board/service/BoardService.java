package board.service;

import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;

public interface BoardService {
	

	public void boardWrite(Map<String, String> map);


	public List<BoardDTO> writeAll(Map<String, Integer> map);


	public int getTotalA();


	public BoardDTO getBoard(int boardSeq);


	public void boardDelete(int seq);


	public void boardModify(Map<String, String> map);


	public List<BoardDTO> boardSearch(Map<String, String> map);


	public int getSearchTotalA(Map<String, String> map);


	public void boardReply(Map<String, String> map);


	public void boardHit(int seq);

	
	
}
