package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

//db랑 연결! component보다는 repository라고 쓴다
@Repository("userDAO")
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
	public UserDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
//	@Autowired
//	public void setDS(DataSource dataSource) {
//		setDataSource(dataSource);
//	}
	
	@Override
	public void userWrite(UserDTO userDTO) {
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