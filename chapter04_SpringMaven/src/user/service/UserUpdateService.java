package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserUpdateService implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserDTO userDTO;
	
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 아이디를 입력하세요");
		String id = scan.next();
		
		//boolean result = userDAO.getCount(id);
		userDTO = userDAO.getUser(id);
		
		if(userDTO != null) {
			System.out.println(userDTO.getId() + "\t" + userDTO.getName() + "\t"  + userDTO.getPwd());
			System.out.println("수정할 이름 입력 : ");
			String name = scan.next();
			System.out.println("수정할 비밀번호 입력 : ");
			String pwd = scan.next();
			
			userDTO.setId(id);
			userDTO.setName(name);
			userDTO.setPwd(pwd);
			
			userDAO.getSujung(userDTO);
			
			System.out.println("데이터를 수정 하였습니다.");
			
		}else {
			System.out.println("찾고자하는 아이디가 없습니다.");
		}
		
		
		
	}

}
