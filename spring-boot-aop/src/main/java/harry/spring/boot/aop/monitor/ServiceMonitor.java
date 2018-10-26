package harry.spring.boot.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 
 * @author harry
 *
 */
@Aspect
@Component
public class ServiceMonitor {
	@AfterReturning("execution(* harry..*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);
	}
}
