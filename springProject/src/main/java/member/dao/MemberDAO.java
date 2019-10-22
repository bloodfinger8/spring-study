package member.dao;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberDAO {
//	public int write(MemberDTO memberDTO);
	public MemberDTO login(Map<String, String> map);
	public MemberDTO isExistId(String id);
//	public MemberDTO getMember(String id);
	public List<ZipcodeDTO> getZipcodeList(Map<String, String> map);
//	public int modify(MemberDTO memberDTO);
}
