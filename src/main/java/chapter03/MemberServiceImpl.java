package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberServiceImpl implements MemberService {
	@Autowired // 자동주입 (빈에 등록된 객체만 가능)
	@Qualifier("yyy") // 빈이름 지정
	private MemberDAO dao;
//	public void setDao(MemberDAO dao) {
//		this.dao = dao;
//	}

	@Override
	public void regist() {
//		MemberDAO dao = new MemberDAOImpl();
		dao.regist();
	}

}
