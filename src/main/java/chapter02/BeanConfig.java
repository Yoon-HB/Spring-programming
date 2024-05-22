package chapter02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAOImpl();
	}
	
	@Bean
	public MemberService memberService() {
		MemberServiceImpl m = new MemberServiceImpl();
		m.setDao(memberDAO());
		return m;
	}
}
