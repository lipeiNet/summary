package com.lp.rabbitMQ;

import com.rabbitmq.client.*;
import com.rabbitmq.client.AMQP.BasicProperties;

import java.io.IOException;

/**
 * Created by Administrator on 2016/10/14.
 * RPC服务器
 */
public class RPCServer {
    private static final String RPC_QUEUE_NAME = "rpc_queue";

    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 1);
    }

    public static void main(String[] args) throws IOException {
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
            channel.basicQos(1);
            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(RPC_QUEUE_NAME, false, consumer);

            System.out.println("RPCServer Awating RPC request");
            while (true) {
                String response = null;
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();

                BasicProperties props = delivery.getProperties();
                BasicProperties replyprops = new AMQP.BasicProperties.Builder().
                        correlationId(props.getCorrelationId()).build();

                try {
                    String message = new String(delivery.getBody(), "UTF-8");
                    int n = Integer.parseInt(message);

                    System.out.println("RPCServer [.] fib(" + message + ")");
                    response = "" + fib(n);
                } catch (Exception e) {
                    System.out.println(" [.] " + e.toString());
                    response = "";
                } finally {
                    channel.basicPublish("", props.getReplyTo(), replyprops, response.getBytes("UTF-8"));
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
