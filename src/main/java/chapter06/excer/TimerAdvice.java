package chapter06.excer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TimerAdvice {
	
	@Pointcut("execution(public * chapter06.excer..*(..))")
	public void timerTarget() {};
	
	@Around("timerTarget()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("메서드 실행전");
		long start = System.nanoTime();
		Object obj = joinPoint.proceed(); // 실제 메서드 실행
		System.out.println("메서드 실행후");
		long end = System.nanoTime();
		System.out.println("소요시간:"+(end-start));
		return obj;
	}
}
