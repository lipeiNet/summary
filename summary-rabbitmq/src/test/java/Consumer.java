import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/10/18.
 */
public class Consumer {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-rabbitmq-server.xml");
        AmqpTemplate amqpTemplate=context.getBean(AmqpTemplate.class);
        Object obj=amqpTemplate.receiveAndConvert("spring.test.queue");
        String message=new String((byte[]) obj,"UTF-8");
        System.out.println("receive:"+message.toString());
    }
}
