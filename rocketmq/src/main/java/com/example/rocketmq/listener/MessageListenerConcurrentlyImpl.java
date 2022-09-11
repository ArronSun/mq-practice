package com.example.rocketmq.listener;

import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: Sunlong
 * @date: 2022/9/9 11:48
 */
public class MessageListenerConcurrentlyImpl implements MessageListenerConcurrently {

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

        if (CollectionUtils.isEmpty(msgs)) {
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }

        MessageExt message = msgs.get(0);
        try {
            final LocalDateTime now = LocalDateTime.now();
            //逐条消费
            String messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("当前时间："+now+"， messageId: " + message.getMsgId() + ",topic: " +
                    message.getTopic()  + ",messageBody: " + messageBody);

            //模拟消费失败
            if ("Concurrently_test20".equals(messageBody)) {
                int a = 1 / 0;
            }

            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } catch (Exception e) {
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }
}
