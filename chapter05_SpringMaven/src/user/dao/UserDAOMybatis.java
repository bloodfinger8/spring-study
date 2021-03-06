package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

// 트랜잭션 기능이 적용된 프록시 객체 생성
@Transactional
@Repository("userDAO")
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public void userWrite(UserDTO userDTO) {
		sqlSession.insert("userSQL.userWrite" , userDTO);
	}

	@Override
	public List<UserDTO> getUserList() {
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		return list;
	}

	@Override
	public UserDTO getUser(String id) {
		 List<UserDTO> userDTO = sqlSession.selectList("userSQL.getUser" , id);
		 
		return userDTO.get(0);
	}

	@Override
	public void getModify(UserDTO userDTO) {
		sqlSession.update("userSQL.getModify", userDTO);
	}

	@Override
	public int userDelete(String id) {
		int su = sqlSession.delete("userSQL.userDelete", id);
		return su;
	}

	
	@Override
	public List<UserDTO> getSearch(Map<String, String> map) {
		List<UserDTO> list = sqlSession.selectList("userSQL.getSearch", map);
		return list;
	}

}
