package chapter10;

import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		System.out.println("vo:"+vo);
		System.out.println(Arrays.toString(vo.getHobbyname()));
		// 파일 저장
//		if (!filename.isEmpty()) { // 사용자가 첨부파일을 첨부했으면
//			System.out.println(filename.getOriginalFilename());
//		}
		
		service.insert(vo);
		// 서블릿으로 응답
		
		return "";
	}
	@GetMapping("/member/idCheck.do")
	public void idCheck(String id, HttpServletResponse res) throws Exception {
		int r = service.idCheck(id);
		PrintWriter pw = res.getWriter();
		pw.print(r);
		pw.close();
	}
	// 로그인폼
	@GetMapping("/member/login.do")
	public void login() {
		
	}
	
	@PostMapping("/member/login.do")
	public void login(MemberVO vo, HttpServletResponse res, HttpSession sess) throws Exception {
		MemberVO login = service.login(vo);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html;charset=utf-8");
		if (login == null) { // 로그인 실패
			pw.println("<script>");
			pw.println("alert('아이디 비밀번호가 잘못됬습니다.');");
			pw.println("history.back();");
			pw.println("</script>");
		} else { // 로그인 성공
			sess.setAttribute("login", login);
			res.sendRedirect("event.do");
		}
		pw.close();
	}
	
	@GetMapping("/member/mypage.do")
	public String mypage(Model model, HttpSession sess) {
		int no = ((MemberVO)sess.getAttribute("login")).getNo();
		MemberVO data = service.mypage(no);
		model.addAttribute("data", data);
		return "/member/mypage";
	}
}
