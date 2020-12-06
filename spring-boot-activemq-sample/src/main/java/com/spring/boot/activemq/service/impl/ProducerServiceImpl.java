package com.spring.boot.activemq.service.impl;

import com.spring.boot.activemq.entity.AdsbDataEntity;
import com.spring.boot.activemq.utility.SerializationUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

/**
 * Created by tongchengfeng on 2016/11/18.
 */
@Service
public class ProducerServiceImpl implements CommandLineRunner {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	@Override
	public void run(String... args) throws Exception {
		sendServiceStr();
	}

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}

	public void send(AdsbDataEntity adsbDataEntity) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, adsbDataEntity);
	}

	public void send(JSONObject jsonObject) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, jsonObject);
	}

	public void sendServiceSerialization(){

		for(int index=0;index<10;index++){

			AdsbDataEntity adsbDataEntity = new AdsbDataEntity();
			adsbDataEntity.setFlightId("YZR7507");
			adsbDataEntity.setModeS("7810AA");
			adsbDataEntity.setNuc(7);
			adsbDataEntity.setLongitude(121.289234);
			adsbDataEntity.setTimeSecond(149507);
			adsbDataEntity.setLatitude(33.91619);
			adsbDataEntity.setModeCHeight(31100);
			adsbDataEntity.setGeometricHeight(31450.0);
			adsbDataEntity.setStationIndex(92);

			String originalStr = SerializationUtils.objectSerialiable(adsbDataEntity);
			send(originalStr);

		}
	}

	public void sendServiceObject(){

		for(int index=0;index<10;index++){

			AdsbDataEntity adsbDataEntity = new AdsbDataEntity();
			adsbDataEntity.setFlightId("YZR7507");
			adsbDataEntity.setModeS("7810AA");
			adsbDataEntity.setNuc(7);
			adsbDataEntity.setLongitude(121.289234);
			adsbDataEntity.setTimeSecond(149507);
			adsbDataEntity.setLatitude(33.91619);
			adsbDataEntity.setModeCHeight(31100);
			adsbDataEntity.setGeometricHeight(31450.0);
			adsbDataEntity.setStationIndex(92);

			send(adsbDataEntity);

		}
	}

	public void sendServiceJson(){

		for(int index=0;index<10;index++){

			AdsbDataEntity adsbDataEntity = new AdsbDataEntity();
			adsbDataEntity.setFlightId("YZR7507");
			adsbDataEntity.setModeS("7810AA");
			adsbDataEntity.setNuc(7);
			adsbDataEntity.setLongitude(121.289234);
			adsbDataEntity.setTimeSecond(149507);
			adsbDataEntity.setLatitude(33.91619);
			adsbDataEntity.setModeCHeight(31100);
			adsbDataEntity.setGeometricHeight(31450.0);
			adsbDataEntity.setStationIndex(92);

			JSONObject jsonObject = JSONObject.fromObject(adsbDataEntity);

			send(jsonObject.toString());

		}
	}

	public void sendServiceStr(){

		String flightId = "YZR7509";

		for(int index=0;index<10;index++){

			AdsbDataEntity adsbDataEntity = new AdsbDataEntity();
			adsbDataEntity.setFlightId(flightId + index);
			adsbDataEntity.setModeS("7810AA");
			adsbDataEntity.setNuc(7);
			adsbDataEntity.setLongitude(121.289234);
			adsbDataEntity.setTimeSecond(149507);
			adsbDataEntity.setLatitude(33.91619);
			adsbDataEntity.setModeCHeight(31100);
			adsbDataEntity.setGeometricHeight(31450.0);
			adsbDataEntity.setStationIndex(92);

			JSONObject jsonObject = JSONObject.fromObject(adsbDataEntity);

			send(jsonObject.toString());

		}
	}




}
