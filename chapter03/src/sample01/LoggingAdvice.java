package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//공통 모듈 ,aspect
public class LoggingAdvice {
	
	public void beforeTrace() {
		System.out.println("before trace..");
	}
	
	public void afterTrace() {
		System.out.println("after trace..");
	}
	
	public void beforeDisplay() {
		System.out.println("beforeDisplay ...");
	}
	
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().toShortString(); //어떤 메소드가 나를 호출했는지 이름을 가져오기
		System.out.println("methodName = " + methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("호출전 : " + methodName);
		
		Object ob = joinPoint.proceed();
		System.out.println("ob = " + ob);
		
		sw.stop();
		System.out.println("호출후 처리시간 =" +methodName);
		System.out.println("ㅇㅇ" + sw.getTotalTimeMillis()/1000);
	}
}
