package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator on 2016/11/15.
 * 将所以的@ExceptionHandler方法集中到一个类中
 * 可以统一的处理一个异常
 * 如果任意的控制器方法抛出DuplicateSpittleException，不管方法位于哪个
 * 控制器中，都会调用duplicateSpittleHandler方法来处理异常
 */
@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(value = DuplicateSpittleException.class)
    public String duplicateSpittleHandler() {
        return "error/duplicate";
    }
}
