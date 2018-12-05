package com.web.api.utils;

import com.google.gson.Gson;
import com.web.api.common.data.Constants;
import com.web.api.common.data.ServiceRuntimeException;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Http请求辅助类
 */
public class HttpClientUtil {

    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 120000;
    private static CloseableHttpClient httpClient = null;
    private static Gson gson = new Gson();

    static {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(100);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        // 在提交请求之前 测试连接是否可用
        configBuilder.setStaleConnectionCheckEnabled(true);
        requestConfig = configBuilder.build();
    }

    private static Logger logger = Logger.getLogger(HttpClientUtil.class);

    /**
     * 生产HttpClient实例
     * 公开，静态的工厂方法，需要使用时才去创建该单体
     */
    public static CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = HttpClients.createDefault();
        }
        return httpClient;
    }

    /**
     * POST请求
     * 1. 接收json参数
     * 2. 可传入header参数
     * @param apiUrl
     * @param jsonStr
     * @return
     */
    public static String doPost(String apiUrl, String jsonStr,Map<String,Object> header) {
        String result = "";
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = getHttpClient();
        HttpPost httpPost = new HttpPost(apiUrl);
        httpPost.setConfig(requestConfig);
        StringEntity req = new StringEntity(jsonStr,"utf-8");//解决中文乱码问题
        req.setContentEncoding("UTF-8");
        req.setContentType("application/json");
        httpPost.setEntity(req);
        httpPost.setHeader("Accept", "application/json");

        //设置header参数
        if(header!=null){
            Iterator<String> iter=header.keySet().iterator();
            while(iter.hasNext()){
                String key=iter.next();
                httpPost.setHeader(key,header.get(key)==null?"":header.get(key).toString());
            }
        }

        try {
            logger.info("调用http接口 : " + apiUrl);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            logger.info("执行状态码 : " + statusCode);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            logger.info("返回报文 : " + result);
        } catch (IOException e) {
            logger.error("调用接口异常: " + e);
            throw new ServiceRuntimeException(Constants.RTN_CODE_FAIL,Constants.RTN_MESSAGE_ERROR);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
