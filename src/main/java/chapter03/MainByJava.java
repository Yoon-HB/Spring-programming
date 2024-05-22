package chapter03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(BeanConfig.class);
		
		
		//ctx.getBean("memberService", MemberService.class).regist();
		MemberService m = ctx.getBean("memberService", MemberServiceImpl.class);
		m.regist();
	}

}
