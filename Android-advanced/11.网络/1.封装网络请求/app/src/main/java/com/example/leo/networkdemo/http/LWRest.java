package com.example.leo.networkdemo.http;

import android.os.AsyncTask;

import org.apache.myhttp.HttpEntity;
import org.apache.myhttp.StatusLine;
import org.apache.myhttp.client.config.RequestConfig;
import org.apache.myhttp.client.methods.CloseableHttpResponse;
import org.apache.myhttp.client.methods.HttpPost;
import org.apache.myhttp.entity.ContentType;
import org.apache.myhttp.entity.StringEntity;
import org.apache.myhttp.impl.client.CloseableHttpClient;
import org.apache.myhttp.impl.client.HttpClients;
import org.apache.myhttp.util.EntityUtils;
import org.myjson.JSONObject;

/**
 * Created by dingdongqianbaofuyin on 2018/9/18.
 */

public class LWRest extends AsyncTask {

    String url;
    JSONObject request;
    int connectTimeout = 3000;
    int socketTimeout = 3000;

    public interface CallBack {
        public void onResult(JSONObject json) throws Exception;
    }
    public CallBack callBack;

    @Override
    protected Object doInBackground(Object[] objects) {
        // 发起请求
        JSONObject response = new JSONObject();

        try {
            String sreq = request.toString();
            String sresp = doPost(url,sreq);
            response = new JSONObject(sresp);
        } catch (Exception e) {
            response.put("errcode", -1001);
            response.put("reason",e.getMessage());
        }

        return response;
    }

    @Override
    protected void onPostExecute(Object o) {
        JSONObject response = (JSONObject)o;
        if (callBack != null) {
            try {
                callBack.onResult(response);
            } catch (Exception e) {
            }
        }
    }


    // 发起POST请求
    private String doPost(String url, String reqText) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(socketTimeout)
                .setConnectTimeout(connectTimeout)
                .build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        //上行数据
        StringEntity dataSent = new StringEntity(reqText, ContentType.create("text/plain","UTF-8"));
        httpPost.setEntity(dataSent);

        CloseableHttpResponse response = httpClient.execute(httpPost);
       try {
           StatusLine statusLine = response.getStatusLine();
           int status = statusLine.getStatusCode();
           if (status != 200) {
               throw  new Exception("HTTP出错");
           }

           //下行数据
           HttpEntity dataRecv = response.getEntity();
           String ss = EntityUtils.toString(dataRecv);
           return ss;
       } finally {
           try {
               httpClient.close();
           } catch (Exception e) {}
       }
    }

    public static void post(String url, JSONObject json, CallBack callBack) {
        LWRest rest = new LWRest();
        rest.callBack = callBack;
        rest.execute();
    }
}
