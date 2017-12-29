package com.mobiecode.webservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ContentRestController {

    @GetMapping(value = {"","/"})
    public String getRest(){
        return "Hello MOBIE!";
    }
}
