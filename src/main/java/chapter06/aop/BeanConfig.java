package chapter06.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import chapter06.excer.Calculator;
import chapter06.excer.CalculatorImpl2;
import chapter06.excer.TimerAdvice;

@Configuration
@EnableAspectJAutoProxy
public class BeanConfig {
	@Bean
	public Calculator calculator() {
		return new CalculatorImpl2();
	}
	@Bean
	public TimerAdvice timerAdvice() {
		return new TimerAdvice();
	}
}
