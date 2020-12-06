package com.spring.boot.activemq.service.mycomsumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * Created by tongchengfeng on 2017/3/31.
 */
@Service
public class ConsumerServiceOne {

//    @Autowired
//    private ActiveMQConnectionFactory activeMQConnectionFactory;


    public static void main(String[] args) {

        // ConnectionFactory ：连接工厂，JMS 用它创建连接
                 ConnectionFactory connectionFactory;

                 // Connection ：JMS 客户端到JMS Provider 的连接
                 Connection connection = null;

                 // Session： 一个发送或接收消息的线程
                 Session session;

                 // Destination ：消息的目的地;消息发送给谁.
                 Destination destination;

                // 消费者，消息接收者
                 MessageConsumer consumer;
                 connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD, "tcp://192.168.11.64:61616");

                try {

                     // 构造从工厂得到连接对象
                    connection = connectionFactory.createConnection();
//                    connection = activeMQConnectionFactory.createConnection();

                     // 启动
                     connection.start();

                    // 获取操作连接
                    session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
                    destination = session.createQueue("ADS_B_MSG");
                    consumer = session.createConsumer(destination);
                    consumer.setMessageListener(new MessageListener() {

                         public void onMessage(Message arg0) {

                                try {
                                         Thread.sleep(1000);
                                 } catch (InterruptedException e1) {
                                         e1.printStackTrace();
                                 }

                                try {
                                         System.out.println("RECEIVE1第一个获得者:" + ((TextMessage) arg0).getText());
                                 } catch (JMSException e) {
                                         // TODO Auto-generated catch block
                                        e.printStackTrace();

                                 }
                             }

                     });

                } catch (Exception e) {
                     e.printStackTrace();
                }

                finally {
                     try {
                         if (null != connection){
                             connection.close();
                         }
                    } catch (Throwable ignore) {
                }

         }

    }
}
