package com.tmup.sample.controller;


import com.google.common.base.Strings;
import com.tmup.sample.Token;
import com.tmup.sample.pojo.SignRequest;
import com.tmup.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by thisno on 2016-04-25.
 */

@Controller
public class SampleController {

    @Autowired
    SampleService sampleService;

    @RequestMapping("/")
    public String index(Model model) {
        return "pages/index";
    }

    @ResponseBody
    @RequestMapping(value = "/signin", method = {RequestMethod.POST})
    public Token sign(@RequestBody SignRequest signRequest) {
        if (signRequest == null || Strings.isNullOrEmpty(signRequest.getEmail()) || Strings.isNullOrEmpty(signRequest.getPassword())) {
            throw new IllegalArgumentException("request error");
        }
        Token token = sampleService.getToken(signRequest);

        return token;
    }
}
