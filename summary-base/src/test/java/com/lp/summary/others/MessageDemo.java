package com.lp.summary.others;

import com.bsi.api.client.MmsClient;
import com.bsi.api.mms.MMSBuilder;
import com.cmcc.mm7.vasp.message.MM7DeliverReq;
import com.cmcc.mm7.vasp.message.MM7DeliveryReportReq;
import com.cmcc.mm7.vasp.message.MM7RSRes;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/22.
 */
public class MessageDemo {
    public static void main(String[] args) {
        final MmsClient mmsBuilder;
        try {
            mmsBuilder = MMSBuilder.getInstance();// 实例化
            // 登陆鉴权
            boolean islogin = mmsBuilder.login(
                    "http://112.33.1.10/app/sdk/login", "lynsyh", "nsyh123",
                    "光谷信息测试3");// Mas网站登录鉴权
            if (!islogin) {
                System.out.println("登录鉴权失败！");
                return;
            }

            String smillocation = "E:\\smil\\smil.zip";
            String msgGroup = Long.toString(System.currentTimeMillis());
            Map<String, String> status = mmsBuilder.sendSmil("sdk发送彩信测试",
                    new String[]{"13720131670"}, "uXT4cWKQ", msgGroup, smillocation);
            System.out.println("RET_CODE:" + status.get("RET_CODE")
                    + "-----RET_MSG:" + status.get("RET_MSG")
                    + "--------RET_MSGGROUP:" + msgGroup);
            System.out.println("正常号码:" + status.get("RET_NORMAL_MOBILES")
                    + "-----非法号码:" + status.get("RET_ILLEGAL_MOBILES"));
            System.out.println("重复号码:" + status.get("RET_REPEAT_MOBILES")
                    + "-----黑名单号码:" + status.get("RET_BLACK_MOBILES")
            );
            Thread t1 = new Thread() {
                public void run() {
                    while (true) {
                        List<MM7RSRes> statussumit = mmsBuilder.getSubmitReport();
                        if (statussumit != null && statussumit.size() > 0) {
                            for (int i = 0; i < statussumit.size(); i++) {
                                System.out.println(statussumit.get(i));
                                System.out.println("提交报告SubmitReportModel===>[");
                                System.out.println("批次号:" + statussumit.get(i).getMsgGroup());
                                System.out.println("手机号:" + statussumit.get(i).getMobies()[0]);
                                System.out.println("实时报告code:" + statussumit.get(i).getStatusCode());
                                System.out.println("实时报告text:" + statussumit.get(i).isStatusCodeExist() + "]");
                            }
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t1.start();
            // 获取状态报告线程
            Thread t2 = new Thread() {
                public void run() {
                    while (true) {
                        List<MM7DeliveryReportReq> StatusReportlist = mmsBuilder.getReport();
                        if (StatusReportlist != null && StatusReportlist.size() > 0) {
                            for (int i = 0; i < StatusReportlist.size(); i++) {
                                System.out.println("状态报告StatusReportlist===>[" + StatusReportlist.get(i) + "]");
                            }
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t2.start();

            // 获取上行线程
            Thread t3 = new Thread() {
                public void run() {
                    while (true) {
                        List<MM7DeliverReq> lis = mmsBuilder.getMO();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t3.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
