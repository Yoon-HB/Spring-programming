package chapter02;

public class MemberServiceImpl implements MemberService {
	
	MemberDAO dao;
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@Override
	public void regist() {
//		MemberDAO dao = new MemberDAOImpl();
		dao.regist();
	}

}
