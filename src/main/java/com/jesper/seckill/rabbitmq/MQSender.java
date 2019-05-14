package com.jesper.seckill.rabbitmq;

import com.jesper.seckill.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiangyunxiong on 2018/5/29.
 */
@Service
public class MQSender {

    private static Logger log = LoggerFactory.getLogger(MQSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

//    public void send(Object message){
//        String msg = RedisService.beanToString(message);
//        log.info("send message:"+msg);
//        amqpTemplate.convertAndSend(MQConfig.QUEUE, message);
//    }

    //[不同]这是topic发送,项目里没用到,在MQConfig里,TOPIC_EXCHANGE绑topic.key1绑new Queue(TOPIC_QUEUE1, true)
    //[不同]TOPIC_EXCHANGE绑topic.#绑new Queue(TOPIC_QUEUE2, true)
    public void sendTopic(Object message) {
		String msg = RedisService.beanToString(message);
		log.info("send topic message:"+msg);
		amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key1", msg+"1");
		amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key2", msg+"2");
	}
    //[不同]本项目用的是这个,直接发送.这里的QUEQE可能和MQConfig里的queue()相关的,但seckill里跳过MQConfig的queue()好像也行
	public void sendSeckillMessage(SeckillMessage message){
        String msg = RedisService.beanToString(message);
        log.info("send message:"+msg);
        amqpTemplate.convertAndSend(MQConfig.QUEUE, msg);

    }
}
