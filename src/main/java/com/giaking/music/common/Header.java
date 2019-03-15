package com.giaking.music.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * /* @author aiden
 * /* @creat  2019/3/12 15:11
 * /* @Description 共同header
 **/
public class Header {

    public static HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("referer","https://c.y.qq.com/");
        headers.add("host","c.y.qq.com");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return headers;
    }
}
