package com.spring.boot.activemq.service.impl;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * Created by tongchengfeng on 2017/04/01.
 * Test
 */
@Service
public class ReceiveMsgTest {

    @Autowired
    private static ActiveMQConnectionFactory activeMQConnectionFactory;

    private static Logger logger = Logger.getLogger(ReceiveMsgTest.class.getName());
    private static  final int sleepTime=30000;

    public static void main(String[] args) {

        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://192.168.11.64:61616");;

        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;

        // Session： 一个发送或接收消息的线程
        Session session;

        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;

        // MessageProducer：消息发送者
        MessageProducer producer;

        // MessageConsumer：消息接收者
        MessageConsumer consumer;

        // TextMessage message;
        try {
            // 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
//            connection = connectionFactory.createConnection();
            connection = activeMQConnectionFactory.createConnection();

            // 启动
            connection.start();

            // 获取操作连接
            session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);

            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
            destination = session.createQueue("ADS_B_MSG");

            // 得到消息生成者【发送者】
            producer = session.createProducer(destination);

            //消息接收者，也就是消费者
            consumer = session.createConsumer(destination);




            // 设置不持久化，此处学习，实际根据项目决定
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        } catch (Exception e) {
            logger.error("Connect to MQ failed:" + e);
            return;
        }


    }
}
