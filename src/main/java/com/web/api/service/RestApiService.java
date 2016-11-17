package com.web.api.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 * Created by xingding on 2016/11/17.
 */
@Service
public class RestApiService {

    public Object mobileLocation(Map<String,Object> params) throws Exception{
        //demo返回值
        String jsonStr = "{\"body\": {\"code\":\"200\",\"reason\":\"Return Successd!\",\"result\":{\"province\":\"浙江\",\"city\":\"杭州\",\"areacode\":\"0571\",\"zip\":\"310000\",\"company\":\"中国移动\",\"card\":\"移动动感地带卡\"} },\"message\":{\"desc\":\"成功\",\"status\":\"000000\" }}";
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        JSONObject body = jsonObject.getJSONObject("body");
        return body.get("result");
    }
}
