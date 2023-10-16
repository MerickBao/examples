package com.example.designpattern.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;

import java.io.IOException;

/**
 * @desc: http请求工具类，用于模拟http请求，实际开发中可以使用HttpClient或者OkHttp等工具类
 * @author: merickbao
 * @since: 2023/10/16 09:02
 */

public class HttpClientUtils {

    public static JSONObject execute(String url, HttpMethod httpMethod) {
        HttpRequestBase http = null;
        try {
            HttpClient httpClient = HttpClients.createDefault();
            if (httpMethod == HttpMethod.GET) {
                http = new HttpGet(url);
            } else if (httpMethod == HttpMethod.POST) {
                http = new HttpPost(url);
            } else if (httpMethod == HttpMethod.PUT) {
                http = new HttpPut(url);
            } else if (httpMethod == HttpMethod.DELETE) {
                http = new HttpDelete(url);
            }
            HttpEntity entity = httpClient.execute(http).getEntity();
            return JSONObject.parseObject(EntityUtils.toString(entity));
        } catch (IOException e) {
            throw new RuntimeException("http request failed url = " + url + " method = " + httpMethod.name() + " error = " + e.getMessage());
        } finally {
            if (http != null) {
                http.releaseConnection();
            }
        }
    }
}
