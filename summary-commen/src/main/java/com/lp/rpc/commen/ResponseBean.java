package com.lp.rpc.commen;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/8.
 */
public class ResponseBean implements Serializable{
    private static final long serialVersionUID = -1L;
    public static final int SUCCESS = 10;
    public static final int FAILURE = 20;
    public static final int LOCKED = 30;
    public static final int EXCEPTION = 40;
    private int returnCode;//返回给消费者的编码（0表示调用成功,1表示调用失败）
    private String returnMsg;//返回给消费者错误信息
    private int dataCount;//用于返回int类型
    private String returnData;//用户返回json
    private Object returnObject;//用于返回对象

    public ResponseBean() {
    }

    public ResponseBean(int returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public Object getReturnObject() {
        return this.returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    public int getDataCount() {
        return this.dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public String getReturnData() {
        return this.returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return this.returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
