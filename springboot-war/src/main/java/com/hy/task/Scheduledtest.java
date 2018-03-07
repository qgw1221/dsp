package com.hy.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component//类级别注解，用来标识一个组件，自定了一个filter，则需要此注解标识之后，Spring Boot才会正确识别。 
public class Scheduledtest {
	@Scheduled(cron = "0 0/2 * * * ?")//initialDelay 从项目开始运行到该函数首次被调用的执行时间，以毫秒计。
	public void fiveMinutes(){
	   System.out.println("====定时任务 每2分钟执行一次！==== ");
	}
}
