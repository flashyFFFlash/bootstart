package com.example.demo.core.rest;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * .
 *
 * @author gxj
 * @since 19-6-20
 */
@Aspect
@Component
@Slf4j
public class RestService {
	/**
	 * 请求告警的时间(ms).
	 */
	private static final long WARNTIME = 200L;

	@Pointcut("execution(public * com.example.demo.controller..*.* (..))")
	public void pointCut() {
	}


	@Before("pointCut()")
	public void doBefore(JoinPoint joinPoint) {
	}

	@Around("pointCut()")
	public Object doAround(ProceedingJoinPoint joinPoint) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		Object result = null;
		try {
			result = joinPoint.proceed();
			long cost = stopwatch.elapsed(TimeUnit.MILLISECONDS);

			Signature signature = joinPoint.getSignature();

			if (cost > WARNTIME) {
				log.warn("{}.{} cost time: {} ms", signature.getDeclaringTypeName(), signature.getName(), cost);
			}
			log.info("{}.{} cost time: {} ms", signature.getDeclaringTypeName(), signature.getName(), cost);
		} catch (Throwable throwable) {
			log.error(throwable.getLocalizedMessage(), throwable);
		}
		return result;
	}


	@AfterReturning("pointCut()")
	public void doAfterReturning(JoinPoint joinPoint) {
	}

}
