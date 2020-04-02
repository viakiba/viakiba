package org.viakiba.dujitang;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class controller {

    @RequestMapping("/")
    public String dujitang() throws IOException {
        Document doc = Jsoup.connect("http://www.nows.fun/").userAgent("Mozilla/5.0 (jsoup)").timeout(5000).get();
        Element sentence = doc.getElementById("sentence");
        String text = sentence.text();
        System.out.println(text);
        return text;
    }


}
