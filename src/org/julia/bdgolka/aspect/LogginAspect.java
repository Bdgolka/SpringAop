package org.julia.bdgolka.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@AfterReturning(pointcut = "args(name)", returning="returnString")
	public void stringArgumentMethods(String name, Object returnString){
		System.out.println("A method that takes String arguments has called. The volue is " + name + " The output value is " + returnString);		
	}
	
	@AfterThrowing(pointcut="args(name)", throwing = "ex")
	public void exceptionAdvice(String name, Exception ex){
		System.out.println("An exception has been thrown "+ ex);
	}
	
	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		Object returnValue = null;
			try {
				System.out.println("Before advice");
				returnValue = proceedingJoinPoint.proceed();
				System.out.println("After Returning");
				} catch (Throwable e) {
				System.out.println("After throwing");
			}	
			
			System.out.println("After Finally");
			return returnValue;
	}

	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

	@Pointcut("within(org.julia.bdgolka.model.Circle)")
	public void allCircleMethods() {
	}

}
