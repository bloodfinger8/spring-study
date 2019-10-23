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


	
	
}
