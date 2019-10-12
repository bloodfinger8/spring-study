package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectService implements UserService {
	@Setter
	private UserDAO userDAO;
	@Setter
	private UserDTO userDTO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("찾는 이름을 입력하세요");
		String name = scan.next();
		
		//DB
		userDTO= userDAO.userSelete(name);
		
		//response
		System.out.println("찾는 이름 : " + userDTO.getId());
		System.out.println("찾는 아이디 : " + userDTO.getId());
		System.out.println("찾는 비밀번호 : " + userDTO.getPwd());
		
		
	}

}
