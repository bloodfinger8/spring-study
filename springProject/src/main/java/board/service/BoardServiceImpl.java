package board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Service(value="boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void boardWrite(Map<String, String> map) {
		boardDAO.boardWrite(map);
	}

	@Override
	public List<BoardDTO> writeAll(Map<String, Integer> map) {
		return boardDAO.writeAll(map);
	}

	@Override
	public int getTotalA() {
		return boardDAO.getTotalA();
	}

	@Override
	public BoardDTO getBoard(int boardSeq) {
		return boardDAO.getBoard(boardSeq);
	}

	@Override
	public void boardDelete(int seq) {
		boardDAO.boardDelete(seq);
	}

	@Override
	public void boardModify(Map<String, String> map) {
		boardDAO.boardModify(map);
	}

	@Override
	public List<BoardDTO> boardSearch(Map<String, String> map) {
		return boardDAO.boardSearch(map);
	}

	@Override
	public int getSearchTotalA(Map<String, String> map) {
		return boardDAO.getSearchTotalA(map);
	}

	@Override
	public void boardReply(Map<String, String> map) {
		boardDAO.boardReply(map);
	}

	@Override
	public void boardHit(int seq) {
		boardDAO.boardHit(seq);
	}



	
	
}
