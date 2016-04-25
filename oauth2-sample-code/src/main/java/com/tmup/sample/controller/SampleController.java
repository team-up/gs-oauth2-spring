package com.tmup.sample.controller;


import com.google.common.base.Strings;
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

    @Value("${oauth.client.secret}")
    private String clientSecret;

    @Value("${teamup.auth}")
    private String authUrl;

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
    public String code(@RequestParam String code) {
        if (Strings.isNullOrEmpty(code)) {
            throw new IllegalArgumentException("code is empty");
        }


        return "";
    }


}
