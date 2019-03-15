package com.giaking.music.api;

import com.giaking.music.common.Header;
import com.giaking.music.common.Params;
import org.apache.commons.codec.EncoderException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * /* @author aiden
 * /* @creat  2019/3/12 14:55
 * /* @Description 歌曲相关api
 **/
@CrossOrigin
@RestController

@RequestMapping("/song")
public class SongApi {


    final String categoryDetailUrl = "https://c.y.qq.com/qzone/fcg-bin/fcg_ucc_getcdinfo_byids_cp.fcg";


    @GetMapping("/category/{dissid}")
    public String getcategoryDetailUrl(@PathVariable String dissid) {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = Header.getHeaders();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("platform", "yqq");
        map.add("hostUin", "0");

        map.add("disstid", dissid);
        map.add("type", "1");
        map.add("json", "1");
        map.add("utf8", "1");
        map.add("onlysong", "0");
        map.add("format", "json");
        map.add("needNewCode", "0");

        map.addAll(Params.CommonParams());
        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = template.postForEntity(categoryDetailUrl, request, String.class);
        return response.getBody();
    }


    @GetMapping("vkey/{songmid}")
    public Object getSlide(@PathVariable String songmid) {
        RestTemplate template = new RestTemplate();
        String url = "https://u.y.qq.com/cgi-bin/musicu.fcg?loginUin=0&hostUin=0&format=json&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq.json&needNewCode=0&" +
                "data=";
        String json = "{\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"10000\"," +
                "\"songmid\":[\"" + songmid + "\"],\"songtype\":[0],\"uin\":\"0\",\"loginflag\":1,\"platform\":\"20\"}},\"comm\":{\"uin\":0,\"format\":\"json\",\"ct\":20,\"cv\":0}}";
        org.apache.commons.codec.net.URLCodec codec = new org.apache.commons.codec.net.URLCodec();

        try {
            url += codec.encode(json);
        } catch (EncoderException e) {
            e.printStackTrace();
        }
        ResponseEntity<String> response = template.getForEntity(url, String.class);

        return response.getBody();
    }
}
