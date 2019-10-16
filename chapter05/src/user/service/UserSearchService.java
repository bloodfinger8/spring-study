package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService{
	@Setter
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
		}
		map.put("key", key);
		map.put("value", value);
		System.out.println(map);
		List<UserDTO> list = userDAO.getSearch(map);
		for(UserDTO data : list) {
			System.out.println(data);
		}
	}


}
