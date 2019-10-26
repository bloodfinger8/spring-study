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


	@Override
	public List<BoardDTO> boardSearch(Map<String, String> map) {
		return sqlSession.selectList("boardSQL.boardSearch" , map);
	}


	@Override
	public int getSearchTotalA(Map<String, String> map) {
		return sqlSession.selectOne("boardSQL.getSearchTotalA",map);
	}


	@Override
	public void boardReply(Map<String, String> map) {
		
		//BoardDTO pDTO = getBoard(boardDTO.getPseq());
		BoardDTO pDTO = getBoard(Integer.parseInt(map.get("pseq")));
		sqlSession.update("boardSQL.boardReply1", pDTO);
		//insert
//		boardDTO.setRef(pDTO.getRef()); //원글ref
//		boardDTO.setLev(pDTO.getLev()+1);//원글lev + 1 
//		boardDTO.setStep(pDTO.getStep()+1);//원글step + 1
		map.put("ref", pDTO.getRef()+"");
		map.put("lev", (pDTO.getLev()+1)+"");
		map.put("step", (pDTO.getStep()+1)+"");
		
		sqlSession.insert("boardSQL.boardReply2", map);
		//reply update
		sqlSession.update("boardSQL.boardReply3", Integer.parseInt(map.get("pseq")));
		
	}
	

	

}
