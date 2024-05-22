package chapter12;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션체크
		HttpSession sess = request.getSession();
		if (sess.getAttribute("login") == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('로그인후 이용가능합니다.');");
			pw.println("location.href='login.do';");
			pw.println("</script>");
			pw.close();
			return false; // 못가
		}
		return true; // 가던길 가
	}
}
