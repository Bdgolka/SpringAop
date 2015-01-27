package org.julia.bdgolka.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.julia.bdgolka.model.Circle;

@Aspect
public class LogginAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint jointPoint) {		
		Circle circle = (Circle) jointPoint.getTarget();
	}
	
	@Before("args(name)")
	public void stringArgumentMethods(String name){
		System.out.println("A method that takes String arguments has called. The volue is " + name);		
	}

	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

	@Pointcut("within(org.julia.bdgolka.model.Circle)")
	public void allCircleMethods() {
	}

}
