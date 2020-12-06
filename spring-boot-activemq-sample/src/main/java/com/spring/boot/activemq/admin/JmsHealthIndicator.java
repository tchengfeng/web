package com.spring.boot.activemq.admin;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

/**
 * Created by tongchengfeng on 2016/11/18.
 */
@Component
public class JmsHealthIndicator extends AbstractHealthIndicator {

    private final ConnectionFactory connectionFactory;

    public JmsHealthIndicator(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Connection connection = this.connectionFactory.createConnection();
        try {
//            connection.start();
            String strValue = connection.getMetaData().getJMSProviderName();
            builder.up().withDetail("provider001",connection.getMetaData().getJMSProviderName());
        } finally {
            connection.close();
        }
    }

}

