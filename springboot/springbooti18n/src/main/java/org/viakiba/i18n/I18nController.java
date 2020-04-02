package org.viakiba.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class I18nController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
    public String index(){

        System.out.println(messageSource.getMessage("hello.world",null, Locale.ENGLISH));


        return "index";
    }
}
