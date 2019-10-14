package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dao.UserDAO;

@Service
public class UserDeleteService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 아이디를 입력하세요");
		String id = scan.next();
		
		
		int su = userDAO.userDelete(id);
		
		if(su == 1) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제할 아이디가 없습니다.");
		}
	}

}
