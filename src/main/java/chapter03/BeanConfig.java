package chapter03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	@Bean
	public MemberDAO xxx() {
		return new MemberDAOImpl();
	}
	
	@Bean
	public MemberDAO yyy() {
		return new MemberDAOImpl2();
	}
	
	@Bean
	public MemberService memberService() {
		MemberServiceImpl m = new MemberServiceImpl();
//		m.setDao(memberDAO());
		return m;
	}
}
