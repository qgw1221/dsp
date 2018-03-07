package com.hy.task;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//https://segmentfault.com/q/1010000008530485
@Component
public class EventSubscriber implements DisposableBean, Runnable, ApplicationListener<ContextRefreshedEvent>{

    private Thread thread;
    private volatile boolean flag=true;

    public EventSubscriber(){
        this.thread = new Thread(this);
        this.thread.setDaemon(true);
        this.thread.start();   
    }

    @Override
    public void run(){
    	if(flag){
    		System.out.println("=== run springboot 启动时的执行线程！ ===");
    		flag=false;
    	}
    	
    }

    @SuppressWarnings("deprecation")
	@Override
    public void destroy(){
    	if(this.thread!=null){
    		System.out.println("===the thread destroy===");
    		this.thread.destroy();
    	}
    	 
    }

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		System.out.println(" ==== 启动 ！===");
		
	}

}