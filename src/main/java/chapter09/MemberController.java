package chapter09;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	
	@GetMapping("/member/insert.do")
	public String insert() {
		return "member/write";
	}
	@Autowired
	private MemberService service;
	
	@PostMapping("/member/insert.do")
	public String insert(MemberVO vo) {
		System.out.println(Arrays.toString(vo.getHobbyname()));
		service.insert(vo);
		// 서블릿으로 응답
		
		return "";
	}
}
