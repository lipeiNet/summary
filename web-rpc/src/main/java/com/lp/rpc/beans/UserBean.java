package com.lp.rpc.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/7.
 */
public class UserBean implements Serializable {
    private Long id;//用户自增长id
    private String username;//用户名
    private String password;//密码
    private String realname;//真实姓名
    private Long userroleid;//用户角色id;
    private Date createdate;//添加日期
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
