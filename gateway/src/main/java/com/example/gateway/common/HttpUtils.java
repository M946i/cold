package com.example.gateway.common;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.util.HashMap;

public class HttpUtils {
    public static String sendPostWithJson(String url) throws IOException {
        // 返回的结果
        String jsonResult;
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        try {
            httpClient.executeMethod(postMethod);
            jsonResult = postMethod.getResponseBodyAsString();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonResult;
    }

    public static HashMap<String, String> mapStringToMap(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        HashMap<String, String> map = new HashMap<>();
        for (String string : strs) {
            String[] keyValue = string.split(":");
            if (keyValue.length < 2) {
                // 如果没有 ":"，将 value 设为 null 或者抛出异常
                throw new IllegalArgumentException("Invalid input: " + string);
            }
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            map.put(key, value);
        }
        return map;
    }


}
