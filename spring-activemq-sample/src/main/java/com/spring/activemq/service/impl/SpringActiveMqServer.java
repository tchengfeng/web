package com.spring.activemq.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tongchengfeng on 2017/6/15.
 */
public class SpringActiveMqServer {
//    ProducerServiceImpl jms = (ProducerServiceImpl)SpringContextManager.getBean("producerServiceImpl");
//    jms.sendMessage("Hello world!");

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml");
    ProducerServiceImpl jms  =  (ProducerServiceImpl) ctx.getBean("producerServiceImpl");

}
