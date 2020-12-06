package com.spring.boot.activemq.controller;

import com.spring.boot.activemq.service.impl.ConsumerServiceImpl;
import com.spring.boot.activemq.service.impl.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tongchengfeng on 2016/11/18.
 */
@RestController
public class MQController{

    @Autowired
    private ProducerServiceImpl produceService;

    @Autowired
    private ConsumerServiceImpl consumerService;

    @RequestMapping(value = "/mq/send/{msg}", method = RequestMethod.POST)
    public String send(@PathVariable String msg) {
        produceService.send(msg);
        return "send";
    }

    // http://localhost:8080/dynaPlan/detail?rowKey=ZUUU287CCA4502ZSSS1
    @RequestMapping(value = "/mq/receive", method = RequestMethod.POST)
    @ResponseBody
    public String receive() {
        String str = consumerService.receive();
        return str;
    }
}