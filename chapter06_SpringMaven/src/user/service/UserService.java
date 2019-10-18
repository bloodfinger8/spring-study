package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserService {
	public void write(UserDTO userDTO);
	public List<UserDTO> getList();
	public UserDTO getUser(String id);
	public void getModify(UserDTO userDTO);
	public void userDelete(String id);
}
