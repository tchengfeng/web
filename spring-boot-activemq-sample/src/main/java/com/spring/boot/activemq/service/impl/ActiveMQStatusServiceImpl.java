package com.spring.boot.activemq.service.impl;

import com.spring.boot.activemq.service.IActiveMQService;
import org.springframework.stereotype.Service;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

/**
 * Created by tongchengfeng on 2016/11/18.
 */
@Service
public class ActiveMQStatusServiceImpl implements IActiveMQService {

    private final ConnectionFactory connectionFactory;

    public ActiveMQStatusServiceImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public String getActiveMQStatus() throws JMSException {
        String mqStatus = "UP";
        Connection connection = null;
        try {
            connection = this.connectionFactory.createConnection();
        } catch (Exception e){
            mqStatus = "DOWN";
        }finally {
            connection.close();
        }

        return mqStatus;
    }

}
