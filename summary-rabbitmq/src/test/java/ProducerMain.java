import com.lp.summary.rabbitmq.domain.Spittle;
import com.migr.common.util.JsonUtil;
import com.migr.common.util.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public class ProducerMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("amqp/amqp-producer.xml");
        AmqpTemplate template = (AmqpTemplate) context.getBean("rabbitTemplate");
      /*  List<Spittle> spittles=new ArrayList<Spittle>();
        for (int i=0;i<5;i++){
            Spittle spittle=new Spittle();
            spittle.setId(1l+i);
            spittle.setMessage("ni"+i);
            spittle.setPostedTime(new Date());
            spittles.add(spittle);
        }
        String data=JsonUtil.g.toJson(spittles);*/
        for (int i=0;i<2;i++){
            template.convertAndSend(i);
        }
        System.out.println("Done!");
    }
}
