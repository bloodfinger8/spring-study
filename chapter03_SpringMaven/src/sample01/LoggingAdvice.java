package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//공통 모듈 ,aspect
@Component
@Aspect
public class LoggingAdvice {
	@Before("execution(public void sample01.MessageBeanImpl.*PrintBefore())")
	public void beforeTrace() {
		System.out.println("before trace..");
	}
	@After("execution(public * *.*.*PrintAfter(..))")
	public void afterTrace() {
		System.out.println("after trace..");
	}
	
	@Around("execution(public * *.*.*Print(..))")
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().toShortString(); //어떤 메소드가 나를 호출했는지 이름을 가져오기
		System.out.println("어떤 메소드가 나를 호출 methodName = " + methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("호출전 : " + methodName);
		
		Object ob = joinPoint.proceed();
		System.out.println("ob = " + ob);
		
		sw.stop();
		System.out.println("호출후 처리시간 =" +methodName);
		System.out.println("처리시간 " + sw.getTotalTimeMillis()/1000 + "초");
	}
}
