package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Transactional
public class UserDAOMybatis implements UserDAO {
	@Setter
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
