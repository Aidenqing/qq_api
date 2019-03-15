package com.giaking.music;

import com.giaking.music.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicApplicationTests {
@Autowired
private TestService service;
    @Test
    public void contextLoads() {

        final String url = "https://c.y.qq.com/musichall/fcgi-bin/fcg_yqqhomepagerecommend.fcg";
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("platform", "h5");
        map.add("uin","0");
        map.add("needNewCode", "1");
        map.add("g_tk", "1928093487");
        map.add("inCharset", "utf-8");
        map.add("outCharset", "utf-8");
        map.add("notice", "0");
        map.add("format", "jsonp");


        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,null);
        ResponseEntity<String> response = template.postForEntity( url, request , String.class );

        System.out.println(response.getBody());

    }



}
