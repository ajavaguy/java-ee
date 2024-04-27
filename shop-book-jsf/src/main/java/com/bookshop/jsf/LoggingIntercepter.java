package com.bookshop.jsf;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logging
@Interceptor
public class LoggingIntercepter implements Serializable {

	private static final long serialVersionUID = 1L;

	public LoggingIntercepter() {
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		System.out.println("Method invoke is: " + ic.getMethod().getName());
		return ic.proceed();
	}

}
