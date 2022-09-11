package com.example.rocketmq.listener;

import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: Sunlong
 * @date: 2022/9/9 18:48
 */
public class MessageListenerOrderlyImpl implements MessageListenerOrderly {

    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
        if (CollectionUtils.isEmpty(msgs)) {
            return ConsumeOrderlyStatus.SUCCESS;
        }

        MessageExt message = msgs.get(0);
        try {
            final LocalDateTime now = LocalDateTime.now();
            //逐条消费
            String messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("当前时间："+now+"， messageId: " + message.getMsgId() + ",topic: " +
                    message.getTopic()  + ",messageBody: " + messageBody);

            //模拟消费失败
            if ("Orderly_test".equals(messageBody)) {
                int a = 1 / 0;
            }

            return ConsumeOrderlyStatus.SUCCESS;
        } catch (Exception e) {
            return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
        }
    }
}
