package com.spring.activemq.listener;

import com.spring.activemq.service.IProducerService;
import com.spring.activemq.service.impl.ProducerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by tongchengfeng on 2017/06/15.
 */
@Component
public class SpringStartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass().toString());



    private static boolean isStart = false;

    @Autowired
    private IProducerService producerService;

//    @Override
    public void onApplicationEvent(ContextRefreshedEvent evt) {

        if(!isStart){
            isStart = true;
            logger.info("Enter SpringStartupListener ...");

            ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml");
            ProducerServiceImpl jms  =  (ProducerServiceImpl) ctx.getBean("producerServiceImpl");
            jms.sendMessage("hello world!");

        }
    }

}
