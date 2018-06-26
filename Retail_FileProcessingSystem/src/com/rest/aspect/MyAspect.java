package com.rest.aspect;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.rest.business.Business;
@Component("aspect")
@Aspect
public class MyAspect {
 //tara
	@Before("execution(* get*())")
	public void beforeAspect()
	{
		System.out.println("before execution method");
		
	}
	/*@Before("execution(* get*())")
	public void aeforeAspect()
	{
		System.out.println("before execution method");
		
	}*/
}
