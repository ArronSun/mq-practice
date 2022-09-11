package com.example.rocketmq.consumer;

import com.example.rocketmq.listener.MessageListenerConcurrentlyImpl;
import com.example.rocketmq.listener.MessageListenerOrderlyImpl;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: Sunlong
 * @date: 2022/9/9 11:31
 */
@Component
public class RetryConsumerDemo {

    @Value("${rocketmq.name-server}")
    private String namesrvAddr;

    @Value("${rocketmq.consumer.topic}")
    private String topic;

    private final DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group");

    @PostConstruct
    public void start() {
        try {
            consumer.setNamesrvAddr(namesrvAddr);
            //设置集群消费模式
            consumer.setMessageModel(MessageModel.CLUSTERING);

            //设置消费超时时间(分钟)
            consumer.setConsumeTimeout(1);

            //订阅主题
            consumer.subscribe(topic , "*");

            //注册消息监听器
            consumer.registerMessageListener(new MessageListenerOrderlyImpl());

            //最大重试次数
            consumer.setMaxReconsumeTimes(2);
            //顺序消费 重试时间间隔
            consumer.setSuspendCurrentQueueTimeMillis(2000);

            //启动消费端
            consumer.start();
            System.out.println("Retry Consumer Start...");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
