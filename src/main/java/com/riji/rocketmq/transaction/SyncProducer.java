package com.riji.rocketmq.transaction;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 发送同步消息
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception{
        //创建消息生产者producer,并指定生产者组名
        TransactionMQProducer producer = new TransactionMQProducer("group5");
        //指定nameserver地址
        producer.setNamesrvAddr("127.0.0.1:9876");

        //事务监听器******
        producer.setTransactionListener(new TransactionListener() {
            /**
             * 在该方法中进行本地事务
             * @param message
             * @param o
             * @return
             */
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                if(StringUtils.equals("TAGA",message.getTags())){
                    //进行本地事务提交
                    return LocalTransactionState.COMMIT_MESSAGE;
                }else if(StringUtils.equals("TAGB",message.getTags())){
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }else if (StringUtils.equals("TAGC",message.getTags())){
                    return LocalTransactionState.UNKNOW;
                }
                return LocalTransactionState.UNKNOW;
            }

            /**
             * 该方法是MQ进行消息事务状态回查
             * @param messageExt
             * @return
             */
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                System.out.println("消息的tag:"+messageExt.getTags());
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });


        //启动producer
        producer.start();

        String[] tags={"TAGA","TAGB","TAGC"};
        for (int i = 0; i < 10; i++) {
            //创建消息对象，指定topic和tag和消息体
            /**
             * 参数一：消息主题topic
             * 参数二：消息tag
             * 参数三：消息内容
             */
            Message msg = new Message("TransactionTopic",tags[i],("Hello World"+i).getBytes());
            msg.putUserProperty("i",String.valueOf(i));
            //发送消息
            SendResult result = producer.sendMessageInTransaction(msg,null);

        }
        //关闭生产者producer
//        producer.shutdown();

    }
}
