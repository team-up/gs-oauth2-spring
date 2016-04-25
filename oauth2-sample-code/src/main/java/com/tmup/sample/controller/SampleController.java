package com.tmup.sample.controller;


import com.google.common.base.Strings;
import com.tmup.sample.Token;
import com.tmup.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by thisno on 2016-04-25.
 */

@Controller
public class SampleController {

    @Value("${oauth.redirecturl}")
    private String redirect;

    @Value("${oauth.client.id}")
    private String clientId;

    @Value("${teamup.auth}")
    private String authUrl;

    @Autowired
    SampleService sampleService;

    @RequestMapping("/")
    public String index(Model model) {

        String url = UriComponentsBuilder.fromUriString(authUrl + "/oauth2/authorize")
                .queryParam("response_type", "code")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", redirect)
                .build().encode().toString();

        model.addAttribute("url", url);
        return "pages/index";
    }


    @RequestMapping("/code")
    public String code(Model model, @RequestParam String code) {
        if (Strings.isNullOrEmpty(code)) {
            throw new IllegalArgumentException("code is empty");
        }
        Token token = sampleService.getToken(code);
        if( token !=null){
            model.addAttribute("token", token);
        }
        return "pages/code";
    }


}
