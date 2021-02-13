package sk.it.strausz.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import sk.it.strausz.Car;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution( * sk.it.strausz.dao.*.*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n======>>> Executing @Before advice");
    }


    @AfterReturning(
            pointcut = "execution(* sk.it.strausz.dao.CarDAO.findCars(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Car> result) {

        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n=====>>>>> Executing @AfterReturning method:  "+method);

        System.out.println();

        System.out.println("\n=====>>>>>@AfterReturning Result is :  "+result);






    }


    @AfterThrowing(pointcut="execution(* sk.it.strausz.dao.CarDAO.findCars(..))",
            throwing = "e"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint,Throwable e){
        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n=====>>>>> Executing @AfterThrowing method:  "+method);


        System.out.println("\n=====>>>>> The exception is:  "+e);


    }

    @After("execution(* sk.it.strausz.dao.CarDAO.findCars(..))")
    public void afterFinally(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();

        System.out.println();
        System.out.println("\n=====>>>>> Executing @AfterFinally method:  "+method);
        System.out.println();

    }


    @Around("execution(* sk.it.strausz.service.*.getHint(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();

        System.out.println("\n=====>>>>> Executing @Around method:  "+method);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("=====> Duration: " + duration / 1000 + " seconds");
        return result;
    }

}
