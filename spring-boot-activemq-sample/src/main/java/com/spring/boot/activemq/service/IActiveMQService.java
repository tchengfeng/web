package com.spring.boot.activemq.service;

import javax.jms.JMSException;

/**
 * Created by tongchengfeng on 2016/11/18.
 */
public interface IActiveMQService {
    String getActiveMQStatus() throws JMSException;
}
