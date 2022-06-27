package com.thienduy.bookmanagement.logger;

import com.thienduy.bookmanagement.util.ReadAndWriteFile;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
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
}
