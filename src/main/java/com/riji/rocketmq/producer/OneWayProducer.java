package com.riji.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 发送单向消息
 */
public class OneWayProducer {
    public static void main(String[] args) throws Exception{
        //创建消息生产者producer,并指定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        //指定nameserver地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        //启动producer
        producer.start();
        for (int i = 0; i < 10; i++) {
            //创建消息对象，指定topic和tag和消息体
            /**
             * 参数一：消息主题topic
             * 参数二：消息tag
             * 参数三：消息内容
             */
            Message msg = new Message("base","Tag3",("Hello World 单向消息"+i).getBytes());
            //发送单向消息
            producer.sendOneway(msg);

        }
        //关闭生产者producer
        producer.shutdown();

    }
}
