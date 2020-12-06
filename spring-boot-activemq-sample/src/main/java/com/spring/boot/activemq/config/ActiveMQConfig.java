package com.spring.boot.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * Created by tongchengfeng on 2016/11/18.
 */
@Configuration
@EnableJms
public class ActiveMQConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("ADS_B_MSG");
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory (){
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(
                        ActiveMQConnectionFactory.DEFAULT_USER,
                        ActiveMQConnectionFactory.DEFAULT_PASSWORD,
//                        "tcp://192.168.0.100:61616");
                        ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        return activeMQConnectionFactory;
    }

}
