package chapter01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		// bean 설정파일(xml)을 읽어들임
		// 설정된 설정값으로 bean(객체) 생성해서 container에 저장
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter01/beans.xml");
		
		// 컨테이너에서 꺼내기(id로)
		Person p = (Person)ctx.getBean("person");
		System.out.println(p);
		
		// 싱글톤객체
		Person p2 = (Person)ctx.getBean("person");
		System.out.println(p == p2);
		
		Person p3 = ctx.getBean("person", Person.class);
		System.out.println(p == p3);
		
		System.out.println(p3.getName());
		
		Person p4 = ctx.getBean("person2", Person.class);
		System.out.println(p == p4);
	}

}
