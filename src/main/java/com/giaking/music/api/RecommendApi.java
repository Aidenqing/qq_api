package com.giaking.music.api;

import com.giaking.music.common.Header;
import com.giaking.music.common.Params;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * /* @author aiden
 * /* @creat  2019/3/12 09:39
 * /* @Description 推荐
 **/
@CrossOrigin
@RestController

@RequestMapping("/recommend")
public class RecommendApi {
    final String slideUrl = "https://c.y.qq.com/musichall/fcgi-bin/fcg_yqqhomepagerecommend.fcg";
    final String listUrl="https://c.y.qq.com/splcloud/fcgi-bin/fcg_get_diss_by_tag.fcg";


    @GetMapping("slide")
    public String getSlide() {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("platform", "h5");
        map.add("uin", "0");
        map.add("needNewCode", "1");
        map.addAll(Params.CommonParams());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, null);
        ResponseEntity<String> response = template.postForEntity(slideUrl, request, String.class);
        return response.getBody();
    }

    @GetMapping("/list")
    public String getList() {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers =Header.getHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("platform", "yqq");
        map.add("hostUin", "0");
        map.add("sin", "0");
        map.add("ein", "29");
        map.add("sortId", "5");
        map.add("needNewCode", "0");
        map.add("categoryId", "10000000");
        map.add("format", "json");
        map.add("rnd", String.valueOf(Math.random()));

        map.addAll(Params.CommonParams());
        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = template.postForEntity(listUrl, request, String.class);
        return response.getBody();
    }
}
