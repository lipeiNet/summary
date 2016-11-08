import com.lp.rpc.commen.Producer;
import com.lp.rpc.commen.QueueConsumer;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/11.
 */
public class AppMain {
    public AppMain() throws Exception {
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        Producer producer = new Producer("queue");
        for (int i = 0; i < 1; i++) {
            HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("Message Number " + i + " sent.");
        }
    }

    public static void main(String[] args) throws Exception {
        new AppMain();
    }
}
