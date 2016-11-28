package spittr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2016/11/15.
 * 抛出指定异常
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {

}
