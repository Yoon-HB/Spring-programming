package chapter11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NormalController {

	@ResponseBody
	@GetMapping("/member/index.do")
	public MemberVO index() {
		MemberVO vo = new MemberVO();
		vo.setNo(1);
		vo.setName("홍길동");
		vo.setId("hong");
		return vo;
	}
}
