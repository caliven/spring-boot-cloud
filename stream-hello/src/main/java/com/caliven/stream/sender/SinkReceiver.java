package com.caliven.stream.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 用于接收来自RabbitMQ消息的消费者SinkReceiver
 * <p>
 * http://blog.didispace.com/spring-cloud-starter-dalston-7-1/
 *
 * RabbitMQ默认控制台：http://localhost:15672   guest/guest
 *
 * @author caliven
 * @date 2018/10/28
 */
@EnableBinding(Sink.class)
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    /**
     * 监听事件，输入监听通道名称定义为Sink.INPUT="input"
     *
     * @param payload
     */
    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Received: " + payload);
    }

}
