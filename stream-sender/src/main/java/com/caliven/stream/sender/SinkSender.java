package com.caliven.stream.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * 消息生产者
 *
 * 启动本项目，查看stream-hello项目控制台，发现只有一个项目控制台打印stream-sender发送过去的消息
 * (
 *      注意：stream-hello项目需要启动多个示例，启动时配置每个项目的spring.cloud.stream.instanceIndex索引，可查看StreamHello2实例配置，
 *      如果索引值相同，会在两个示例控制台同时打印收到的消息，达不到生产者产生的消息只被其中一个实例消费的效果
 * )
 */
@EnableBinding(value = {Source.class})
public class SinkSender {

    private static Logger logger = LoggerFactory.getLogger(SinkSender.class);

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage<>("{\"name\":\"caliven\", \"age\":28}");
    }

}