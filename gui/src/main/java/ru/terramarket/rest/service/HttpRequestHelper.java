package ru.terramarket.rest.service;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

public class HttpRequestHelper {
    private HttpClient hc;
    private String baseAddress = "";


    public HttpRequestHelper() {
        baseAddress = "http://localhost:18080/terramarket/";
        hc = new DefaultHttpClient();
        hc.getParams().setParameter("http.protocol.content-charset", "UTF-8");
    }

    public String runSimpleJsonRequest(String uri) {
        HttpGet httpGet = new HttpGet(baseAddress + uri);
        return runRequest(httpGet);
    }

    private String runRequest(HttpUriRequest httpRequest) {
        StringBuilder builder = new StringBuilder();
        try {
            httpRequest.setHeader("Cookie", "JSESSIONID=" + SessionHolder.session);
            HttpResponse response = null;
            try {
                response = hc.execute(httpRequest);
            } catch (ConnectException e) {
                return null;
            } catch (IllegalStateException e) {
                return null;
            }
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();

            if (HttpStatus.SC_OK == statusCode) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else if (HttpStatus.SC_FORBIDDEN == statusCode) {
            } else {
            }
        } catch (ConnectException e) {
            e.printStackTrace();
            return null;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return builder.toString();
    }

    public String runJsonRequest(String uri, NameValuePair... params) {
        HttpPost request = new HttpPost(baseAddress + uri);

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        for (int i = 0; i < params.length; ++i) {
            nameValuePairs.add(params[i]);
        }

        request.addHeader("Content-Type", "application/x-www-form-urlencoded");
        UrlEncodedFormEntity entity;
        try {
            entity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
            entity.setContentType("appplication/x-www-form-urlencoded");
            request.setEntity(entity);

            return runRequest(request);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}