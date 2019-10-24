package board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import board.bean.BoardDTO;

@Transactional
@Repository("boardDAO")
public class BoardDAOMybatis implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public void boardWrite(Map<String, String> map) {
		sqlSession.insert("boardSQL.boardWrite", map);
	}


	@Override
	public List<BoardDTO> writeAll(Map<String, Integer> map) {
		return sqlSession.selectList("boardSQL.writeAll" , map);
	}


	@Override
	public int getTotalA() {
		return sqlSession.selectOne("boardSQL.getTotalA");
	}


	@Override
	public BoardDTO getBoard(int seq) {
		return sqlSession.selectOne("boardSQL.getBoard" , seq);
	}


	@Override
	public void boardDelete(int seq) {
		sqlSession.delete("boardSQL.boardDelete", seq);
	}


	@Override
	public int boardModify(Map<String, String> map) {
		return sqlSession.update("boardSQL.boardModify" , map);
	}
	

	

}
