package com.actonate.carrier_label_service.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class APICaller {
    public static String postAPICall(String apiUrl, String queryString, Map<String, String> reqHeader) {
        HttpClient client = null;
        HttpPost method = null;
        StringEntity input = null;
        HttpResponse response = null;
        BufferedReader rd = null;
        String result = "";
        String line = null;
        try {
            client = new DefaultHttpClient();
            method = new HttpPost(apiUrl);
            if (queryString != null && queryString.length() > 0) {
                input = new StringEntity(queryString);
                method.setEntity(input);
            }
            if (reqHeader != null) {
                for (Map.Entry<String, String> entry : reqHeader.entrySet()) {
                    method.addHeader(entry.getKey(), entry.getValue());
                    System.out.println(entry.getKey() + "===response==" + entry.getValue());
                }
            }
            // method.addHeader("Content-Type", "application/json");
            response = client.execute(method);
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            System.out.println("response status code >>>>>>> =" + response.getStatusLine().getStatusCode());
            while ((line = rd.readLine()) != null) {
                // System.out.println(">>>>>>>>> line >>>>>>> " +line);
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rd != null)
                    rd.close();
                client.getConnectionManager().shutdown();
            } catch (Exception e) {
            }
        }
        return result;
    }

    static String getAPICall(String apiUrl, Map<String, String> reqHeader) {
        HttpClient client = null;
        HttpGet method = null;
        HttpResponse response = null;
        BufferedReader rd = null;
        String result = "";
        String line = null;
        try {
            client = new DefaultHttpClient();
            method = new HttpGet(apiUrl);
            if (reqHeader != null) {
                for (Map.Entry<String, String> entry : reqHeader.entrySet()) {
                    method.addHeader(entry.getKey(), entry.getValue());
                    System.out.println(entry.getKey() + "==" + entry.getValue());
                }
            }
            response = client.execute(method);
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            System.out.println("response status code=" + response.getStatusLine().getStatusCode());
            while ((line = rd.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rd != null)
                    rd.close();
                client.getConnectionManager().shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}