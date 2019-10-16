package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserSearchService implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1.이름 검색");
		System.out.println("2.아이디 검색");
		int input = scan.nextInt();
		
		Map<String, String> map = new HashMap<String, String>();
		String key = null;
		String value = null;
		if(input == 1) {
			System.out.println("검색을 원하는 이름 입력 : ");
			String name = scan.next();
			key = "name";
			value = name;
		}else if(input == 2){
			System.out.println("검색을 원하는 아이디 입력 : ");
			String id = scan.next();
			key = "id";
			value = id;
		}else {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		map.put("key", key);
		map.put("value", value);
		
		//DB
		List<UserDTO> list = userDAO.getSearch(map);
		
		//출력
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		}
	}


}
