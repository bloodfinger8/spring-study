package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import user.bean.UserDTO;

//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//
//import lombok.Setter;
//import user.bean.UserDTO;
//
//public class UserDAOImpl implements UserDAO {
//	@Setter
//	private JdbcTemplate jdbcTemplate;
//	
//	@Override
//	public void userWrite(UserDTO userDTO) {
//		String sql = "insert into usertable values(?,?,?)";
//		jdbcTemplate.update(sql,userDTO.getName(), userDTO.getId(), userDTO.getPwd());
//	}
//
//	@Override
//	public UserDTO userSelete(String name) {
//		String sql = "select * from usertable where name=?";
//		return (UserDTO) jdbcTemplate.queryForObject(sql,
//                new Object[] {name}, new BeanPropertyRowMapper<>(UserDTO.class));
//	}
//
//	@Override
//	public void userUpdate(UserDTO userDTO) {
//		String sql = "select count(*) from usertable where name = ?";
//	}
//	@Override
//	public void userDelete(String name) {
//	}
//
//}

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

	
	@Override
	public void userWrite(UserDTO userDTO) {
		//String sql = "insert into usertable values(?,?,?)";
		//getJdbcTemplate().update(sql,userDTO.getName(), userDTO.getId(), userDTO.getPwd());
		String sql = "insert into usertable values(:name,:id,:pwd)";
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id" , userDTO.getId());
		map.put("pwd" , userDTO.getPwd());
		getNamedParameterJdbcTemplate().update(sql, map);
	}
	
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
//	@Override
//	public boolean getCount(String id) {
//		boolean result = false;
//		String sql = "select count(*) from usertable where id = ?";
//		int count = getJdbcTemplate().queryForObject(
//                sql, new Object[] { id }, Integer.class);
//		if (count > 0) {
//			result = true;
//		}
//		return result;
//	}
	@Override
	public void getSujung(UserDTO userDTO) {
		String sql = "update usertable set name = :name, pwd = :pwd where id = :id ";
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id" , userDTO.getId());
		map.put("pwd" , userDTO.getPwd());
		getNamedParameterJdbcTemplate().update(sql, map);
	}
	
	@Override
	public int userDelete(String id) {
		String sql = "delete from usertable where id = :id";
		return getJdbcTemplate().update(sql,id);
	}

	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id = :id";
		try {
			return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class) , id );
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	
}