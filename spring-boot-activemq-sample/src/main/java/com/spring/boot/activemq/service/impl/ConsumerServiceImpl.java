package com.spring.boot.activemq.service.impl;

import com.spring.boot.activemq.entity.AdsbDataEntity;
import org.springframework.stereotype.Service;

/**
 * Created by tongchengfeng on 2016/11/18.
 */
@Service
public class ConsumerServiceImpl {

	private String text;

	private AdsbDataEntity adsbDataEntity;

//	@JmsListener(destination = "ADS_B_MSG")
//	public void receiveQueue(String text) {
//		this.text = text;
//		this.adsbDataEntity = (AdsbDataEntity) SerializationUtils.objectDeserialization(this.text);
//		System.out.println(text);
//	}

//	@JmsListener(destination = "ADS_B_MSG")
//	public void receiveQueue(AdsbDataEntity adsbDataEntity) {
//		this.adsbDataEntity = adsbDataEntity;
//		System.out.println(adsbDataEntity.toString());
//	}

//	@JmsListener(destination = "ADS_B_MSG")
//	public void receiveQueue(JSONObject jsonObject) {
		// this.adsbDataEntity =  (AdsbDataEntity)JSONObject.toBean(jsonObject,AdsbDataEntity.class);
//	}

//	@JmsListener(destination = "ADS_B_MSG")
//	public void receiveQueue(String message) {
//		JSONObject obj = new JSONObject().fromObject(message);
//		this.adsbDataEntity = (AdsbDataEntity)JSONObject.toBean(obj,AdsbDataEntity.class);
//	}

	public String receive() {
		return text;
	}


}
