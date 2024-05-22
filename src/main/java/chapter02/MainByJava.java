package chapter02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainByJava {

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(BeanConfig.class);
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("chapter02/beans.xml");
		
		
		//ctx.getBean("memberService", MemberService.class).regist();
		MemberService m = ctx.getBean("memberService", MemberServiceImpl.class);
		m.regist();
	}

}
