package com.lp.rpc;

import com.lp.rpc.commen.ResponseBean;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/6.
 */
@Service
public interface ApiService {
     String getToken();
     ResponseBean add(String reqJson);
}
