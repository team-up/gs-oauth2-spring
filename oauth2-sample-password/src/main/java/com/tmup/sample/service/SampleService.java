package com.tmup.sample.service;

import com.tmup.sample.Token;
import com.tmup.sample.pojo.SignRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by thisno on 2016-04-25.
 */

@Service
public class SampleService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${teamup.auth}")
    private String authUrl;

    @Value("${oauth.client.id}")
    private String clientId;

    @Value("${oauth.client.secret}")
    private String clientSecret;


    public Token getToken(SignRequest signRequest){
        String url = authUrl + "/oauth2/token";

        MultiValueMap<String, Object> data = new LinkedMultiValueMap<>();
        data.add("grant_type", "password");
        data.add("client_id", clientId);
        data.add("client_secret", clientSecret);
        data.add("username", signRequest.getEmail());
        data.add("password", signRequest.getPassword());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<Object> httpEntity = new HttpEntity<Object>(data, header);

        ResponseEntity<Token> responseEntity =  restTemplate.postForEntity(url, httpEntity, Token.class);
        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            return responseEntity.getBody();
        }
        return null;
    }

}
