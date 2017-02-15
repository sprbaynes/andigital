package com.angular.spring.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

/**
 * Created by steven.baynes on 02/02/2016.
 */
public class HttpHelper {

    public static final HttpHeaders headers = new HttpHeaders();
    public static final HttpHeaders responseHeaders = new HttpHeaders();

    static {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    public static HttpEntity<String> getHttpEntity(String json)
    {
        return new HttpEntity<String>((json == null)?"":json, headers);
    }
}
