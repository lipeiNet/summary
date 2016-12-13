import com.lp.summary.rabbitmq.domain.Spittle;
import com.migr.common.util.JsonUtil;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/9.
 */
public class MyTest {
    public static void main(String[] args) {
        Spittle spittle1 = new Spittle((long) 1, null, "Hello world (" + 1 + ")", new Date());
        String str=JsonUtil.g.toJson(spittle1);
        Spittle spittle= JsonUtil.g.fromJson(str,Spittle.class);
        System.out.println("1");
    }
}
