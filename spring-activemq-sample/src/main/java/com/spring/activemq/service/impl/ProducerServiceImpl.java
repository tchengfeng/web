package com.spring.activemq.service.impl;

import com.spring.activemq.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by tongchengfeng on 2017/06/15.
 */
@Service
public class ProducerServiceImpl implements IProducerService {

	@Resource
	private JmsTemplate jmsTemplate;

	@Qualifier("CDM_MSG")
	@Autowired
	private Destination destination;

	public void sendMessage(final String message) {
		jmsTemplate.send(destination, new MessageCreator() {
//			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}

}
