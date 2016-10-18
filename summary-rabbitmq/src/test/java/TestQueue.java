import com.lp.summary.rabbitmq.MQProducer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/10/17.
 */
public class TestQueue {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-rabbitmq-producer.xml");
        MQProducer mqProducer=(MQProducer) context.getBean("mqProducer");
        mqProducer.sendDateToQueue("spring.test.queueKey","Hello World");
    }
}
