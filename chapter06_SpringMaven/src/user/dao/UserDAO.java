package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {
	public void write(UserDTO userDTO);
	public List<UserDTO> getList();
	public UserDTO getUser(String id);
	public void getModify(UserDTO userDTO);
	public int userDelete(String id);
	public List<UserDTO> getSearch(Map<String, String> map);
}

