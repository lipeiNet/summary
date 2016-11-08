package com.lp.rpc;

import com.lp.web.beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/2.
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "dologin",method = RequestMethod.POST)
     public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        if (userService.isExist(userBean)){
            return new ModelAndView("successful");
        }
        return new ModelAndView("add");
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(){
        return "add";
    }
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(HttpServletRequest request, HttpServletResponse response)
    {
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        String userroleid=request.getParameter("userroleid");
        String realname=request.getParameter("realname");
        UserBean userBean=new UserBean();
        userBean.setUsername(userName);
        userBean.setPassword(password);
        userBean.setCreatedate(new Date());
        userBean.setRealname(realname);
        userBean.setUserroleid(Long.parseLong(userroleid));
       if (userService.add(userBean)){
           return "successful";
       }
        return "error";
    }
    @RequestMapping(value = "mytest")
    @ResponseBody
    public String returnOk(){
        return "Ok";
    }
}
