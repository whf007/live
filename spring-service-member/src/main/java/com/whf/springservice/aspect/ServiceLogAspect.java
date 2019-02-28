package com.whf.springservice.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class ServiceLogAspect {
    ThreadLocal<Long> startTime = new ThreadLocal<>();// 开始时间
    ThreadLocal<Long> startTimes = new ThreadLocal<>();//开始时间

    /**
     * map1存放方法被调用的次数O
     */
    ThreadLocal<Map<String, Long>> map1 = new ThreadLocal<>();

    /**
     * map2存放方法总耗时
     */
    ThreadLocal<Map<String, Long>> map2 = new ThreadLocal<>();


    @Pointcut("execution(public * com.whf.springservice.service.impl..*.*(..))")
    public void serviceLog() {
    }


    /**
     * Aop：环绕通知 切整个包下面的所有涉及到调用的方法的信息
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("serviceLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        //初始化 一次
        if (map1.get() == null) {
            map1.set(new HashMap<>());

        }
        if (map2.get() == null) {
            map2.set(new HashMap<>());
        }

        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            if (result == null) {
//如果切到了 没有返回类型的void方法，这里直接返回 
                return null;
            }
            long end = System.currentTimeMillis();

            log.info("===================");
            String tragetClassName = joinPoint.getSignature().getDeclaringTypeName();
            String MethodName = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();// 参数
            int argsSize = args.length;
            String argsTypes = "";
            String typeStr = joinPoint.getSignature().getDeclaringType().toString().split(" ")[0];
            String returnType = joinPoint.getSignature().toString().split(" ")[0];
            log.info("类/接口:" + tragetClassName + "(" + typeStr + ")");
            log.info("方法:" + MethodName);
            log.info("参数个数:" + argsSize);
            log.info("返回类型:" + returnType);
            if (argsSize > 0) {
                // 拿到参数的类型
                for (Object object : args) {
                    argsTypes += object.getClass().getTypeName().toString() + " ";
                }
                log.info("参数类型：" + argsTypes);
            }

            Long total = end - start;
            log.info("耗时: " + total + " ms!");

            if (map1.get().containsKey(MethodName)) {
                Long count = map1.get().get(MethodName);
                map1.get().remove(MethodName);//先移除，在增加
                map1.get().put(MethodName, count + 1);

                count = map2.get().get(MethodName);
                map2.get().remove(MethodName);
                map2.get().put(MethodName, count + total);
            } else {

                map1.get().put(MethodName, 1L);
                map2.get().put(MethodName, total);
            }

            return result;

        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            log.info("====around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : "
                    + e.getMessage());
            throw e;
        }

    }


    @Before("serviceLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning( pointcut = "serviceLog()")
    public void afterMehhod(JoinPoint  jp) throws Throwable {
        long end = System.currentTimeMillis();
        long total = end - startTime.get();
        String methodName = jp.getSignature().getName();
        log.info("连接点方法为：" + methodName + ",执行总耗时为：" + total + "ms");

        //重新new一个map
        Map<String, Long> map = new HashMap<>();

        //从map2中将最后的 连接点方法给移除了，替换成最终的，避免连接点方法多次进行叠加计算
        //由于map2受ThreadLocal的保护，这里不支持remove，因此，需要单开一个map进行数据交接
        for (Map.Entry<String, Long> entry : map2.get().entrySet()) {
            if (entry.getKey().equals(methodName)) {
                map.put(methodName, total);

            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }

        for (Map.Entry<String, Long> entry : map1.get().entrySet()) {
            for (Map.Entry<String, Long> entry2 : map.entrySet()) {
                if (entry.getKey().equals(entry2.getKey())) {
                    System.err.println(entry.getKey() + ",被调用次数：" + entry.getValue() + ",综合耗时：" + entry2.getValue() + "ms");
                }
            }

        }

    }

}
