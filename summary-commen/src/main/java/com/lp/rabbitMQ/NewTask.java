package com.lp.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2016/10/13.
 */
public class NewTask {
    private static final String TASK_QUEUE_NAME="task_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();

        //String queue, boolean durable(是否持久化), boolean exclusive(是否独占队列),
        // boolean autoDelete(是否自动删除队列),Map<String, Object> arguments
        channel.queueDeclare(TASK_QUEUE_NAME,true,false,false,null);
        //分发信息
        for (int i=0;i<10;i++){
            String message="Hello RabbitMQ"+i;
            //第一个参数就是交换器的名称。如果输入“”空字符串，表示使用默认的匿名交换器。
            //第二个参数是【routingKey】路由线索
            //匿名交换器规则：
            //发送到routingKey名称对应的队列。
            channel.basicPublish("",TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            System.out.println("NewTask send '"+message+"'");
        }
        channel.close();
        connection.close();
    }
}
