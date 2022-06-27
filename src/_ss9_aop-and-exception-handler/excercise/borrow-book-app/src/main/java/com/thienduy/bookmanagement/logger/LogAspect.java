package com.thienduy.bookmanagement.logger;

import com.thienduy.bookmanagement.util.ReadAndWriteFile;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class LogAspect {
    private final String PATH = "D:\\CG_FULL_STACK\\CG_MODULE_4\\src\\_ss9_aop-and-exception-handler\\excercise\\borrow-book-app\\src\\main\\resources\\file_log\\file-log.csv";

    @Pointcut("execution(* com.thienduy.bookmanagement.controller.BookController.*(..))")
    public void allMethodPointCut() {
    }

    @After("allMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint) {
        String mess = "METHOD NAME: "
                + joinPoint.getSignature().getName() +
                " TIME: " + LocalDate.now();
        List<String> stringList = new ArrayList<>();
        stringList.add(mess);
        System.err.println(mess);
        ReadAndWriteFile.writeListStringToCSV(PATH, stringList);
    }

    @AfterThrowing(pointcut = "execution(public * com.thienduy.bookmanagement.service.impl.BooksService.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        String mess = String.format("[BOOK] EXCEPTION AT: %s.%s%s: %s", className, method, args, e.getMessage());
        List<String> stringList = new ArrayList<>();
        stringList.add(mess);
        ReadAndWriteFile.writeListStringToCSV(PATH, stringList);
        System.out.println(mess);
    }
}
