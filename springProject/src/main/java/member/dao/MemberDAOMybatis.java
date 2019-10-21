package member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

@Transactional
@Repository("memberDAO")
public class MemberDAOMybatis implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int write(MemberDTO memberDTO) {
		return 0;
	}

	@Override
	public MemberDTO login(Map<String, String> map) {
		return sqlSession.selectOne("memberSQL.login", map);
	}

	@Override
	public boolean isExistId(String id) {
		return false;
	}

	@Override
	public MemberDTO getMember(String id) {
		return null;
	}

	@Override
	public List<ZipcodeDTO> getZipcodeList(Map<String, String> map) {
		return null;
	}

	@Override
	public int modify(MemberDTO memberDTO) {
		return 0;
	}

}
