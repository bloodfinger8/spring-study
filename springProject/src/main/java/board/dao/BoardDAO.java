package board.dao;

import java.util.List;
import java.util.Map;
import board.bean.BoardDTO;


public interface BoardDAO {
	public void boardWrite(Map<String,String> map);
	public List<BoardDTO> writeAll(Map<String, Integer> map);
	public int getTotalA();
	public BoardDTO getBoard(int seq);
	
	public int boardModify(Map<String,String> map);
//	public void boardHit(int seq);
	public void boardDelete(int seq);
	public List<BoardDTO> boardSearch(Map<String, String> map);
	public int getSearchTotalA(Map<String, String> map);
	public void boardReply(Map<String, String> map);
}
