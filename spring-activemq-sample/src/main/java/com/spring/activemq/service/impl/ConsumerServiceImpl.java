package com.spring.activemq.service.impl;

import com.spring.activemq.service.IConsumerService;
import org.springframework.stereotype.Service;

/**
 * Created by tongchengfeng on 2017/03/21.
 */
@Service
public class ConsumerServiceImpl implements IConsumerService {

//	@JmsListener(destination = "CDM_MSG")
	public void receiveMessage(String message) {
		System.out.println("received message from queue, the information is :" + message);
	}

}
