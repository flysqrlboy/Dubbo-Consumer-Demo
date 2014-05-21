package com.flysqrlboy.dubbo_client.demo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flysqrlboy.service.bean.Person;
import com.flysqrlboy.service.interf.DemoService;
import com.flysqrlboy.service.interf.HelloService;

public class Consumer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果
        int account = demoService.getAccount(10000);
        System.out.println( account );
        
        HelloService helloService = (HelloService)context.getBean("helloService");// 获取远程服务代理
        Person person = helloService.getPerson("flysqrlboy", 100);
        
        System.out.println(person);
        
	}
}
