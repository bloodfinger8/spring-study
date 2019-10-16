package user.service;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import oracle.jdbc.proxy.annotation.GetProxy;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectService implements UserService {
	@Setter
	private UserDAO userDAO;
	@Setter
	private UserDTO userDTO;
	
	@Override
	public void execute() {
		
		List<UserDTO> list = userDAO.getUserList();
		
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		}
		
	}

}
