package chapter05;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member") // 모든 메서드의 URL앞에 포함
public class MemberController {

	// method가 없는 경우 : 모든 method 다 가능
	@RequestMapping({"/member/index.do","/member/index2.do", "/member.do"} )
	public String index() {
		System.out.println("index");
		return "member/index";
	}
	// /index.do URL로 POST 방식만 접근
	@RequestMapping(value="/index.do", method = RequestMethod.POST)
	public String index2() {
		System.out.println("index");
		return "home";
	}
	
	// /index2.do GET
	@GetMapping("/index.do") // /member/index.do
	public String index22() {
		return "member/index"; // /WEB-INF/views/[  ].jsp
	}
	// /member/test/index.do
	@GetMapping("/test/index.do")
	public void test() {
		// void인 경우 URL과 동일한 경로로 포워딩
	}
	// 리다이렉트
	// /member/test.do -> /member/test/index.do
	@GetMapping("/test.do")
	public String test2() {
//		return "redirect: /test/member/test/index.do";
		return "redirect:/member/test/index.do";
	}
	
	// 파라미터 받는 방법
	// 1. HttpServletRequest
	@GetMapping("/param1.do")
	public String param1(HttpServletRequest req) {
		String id = req.getParameter("id");
		System.out.println("id:"+id);
		return "member/param1";
	}
	// 2. @RequestParam
	@GetMapping("/param2.do")
	public String param2(@RequestParam(name="id",
										required = false,
										defaultValue = "nobody") String ids, 
						int age) {
		String id = "";
		System.out.println("id:"+ids);
		System.out.println("age:"+age);
		return "member/param1";
	}
	// 3. 커맨드 객체(@ModelAttribute)
	// 파라미터이름과 setter (id -> setId())
	// 모든 파라미터 중 해당하는 값을 vo에 저장
	// request에도 저장
	@GetMapping("/param3.do")
	public String param3(
				//@ModelAttribute("mem") MemberVO vo
				MemberVO vo
				) {
		System.out.println(vo);
		return "member/param1";
	}
	
	// 4. @PathVariable
	// /member/view/kim -> kim값이 id변수에 저장
	@GetMapping("/view/{id}/{name}")
	public String param4(@PathVariable String id, 
						@PathVariable String name) {
		System.out.println("id:"+id);
		System.out.println("name:"+name);
		return "member/param1";
	}
	
	// /member/event.do
//	@GetMapping("/member/event.do")
//	public void event() {
//		
//	}
	
	@GetMapping("/save.do")
	public ModelAndView save(HttpServletRequest req,
						Model model) {
		
		// request 저장
		req.setAttribute("name", "홍길동");
		model.addAttribute("email", "hong@gmail.com");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/save");
		mav.addObject("id", "hong");
		
		// session 저장
		HttpSession sess = req.getSession();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "이순신");
		map.put("age", 40);
		map.put("id", "lee");
		sess.setAttribute("login", map);
		return mav;
	}
}
