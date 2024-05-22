package chapter01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	// 빈등록 (메서드)
	// 빈이름 - 메서드이름
	@Bean
	public Person person() {
		return new Person();
	}
	
}
