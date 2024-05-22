package chapter09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
	@Autowired
	private MemberMapper mapper;
	
	@Transactional
	public boolean insert(MemberVO vo) {
		System.out.println("insert 전 : "+vo.getNo());
		int result = mapper.insert(vo);
		System.out.println("insert 후 : "+vo.getNo());
		if (result > 0) {
			// 취미 등록
			HobbyVO hvo = new HobbyVO();
			// member PK?
			hvo.setMember_no(vo.getNo());
			for (String name : vo.getHobbyname()) {
				hvo.setName(name);
				mapper.insertHobby(hvo);
			}
			return true;
		}
		
		return false;
	}
}
