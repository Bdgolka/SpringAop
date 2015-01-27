package org.julia.bdgolka.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogginAspect {
	
	@Before("allGetters() && allCircleMethods()")
	public void LoggingAdvice()	{
		System.out.println("Advice run. Get Method called.");
	}

	@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("Second Advice executed.");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters(){}
	
	
	@Pointcut("within(org.julia.bdgolka.model.Circle)")
	public void allCircleMethods(){}
	
}
