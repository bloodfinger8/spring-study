package user.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.Setter;
import user.bean.UserDTO;

public class UserDAOImpl implements UserDAO {
	@Setter
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void userWrite(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql,userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}

	@Override
	public UserDTO userSelete(String name) {
		String sql = "select * from usertable where name=?";
		return (UserDTO) jdbcTemplate.queryForObject(sql,
                new Object[] {name}, new BeanPropertyRowMapper<>(UserDTO.class));
	}

	@Override
	public void userUpdate(UserDTO userDTO) {
	}
	@Override
	public void userDelete(String name) {
	}

}
