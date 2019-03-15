package com.giaking.music.common;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * /* @author aiden
 * /* @creat  2019/3/12 09:36
 * /* @Description 公共参数
 **/
public class Params {

    public  static MultiValueMap CommonParams(){
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("g_tk", "1928093487");
        map.add("inCharset", "utf-8");
        map.add("outCharset", "utf-8");
        map.add("notice", "0");
        map.add("format", "jsonp");
        return map;
    }
}
