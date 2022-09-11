package com.example.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Sunlong
 * @date: 2022/9/6 17:41
 */
//@RocketMQMessageListener(topic = "${rocketmq.consumer.topic}",consumerGroup ="${rocketmq.consumer.group}")
//@Component
//public class ConsumerTagADemo implements RocketMQListener<String> , MessageListener {
//
//    @Override
//    public void onMessage(String o) {
//        if ("DLQ1".equals(o)) {
//            double a = 1/0;
//        }
//
//        System.out.println("ConsumerTagADemo onMessage="+o);
//    }
//}
