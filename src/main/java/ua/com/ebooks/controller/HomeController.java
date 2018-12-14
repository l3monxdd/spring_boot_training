package ua.com.ebooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.ebooks.dao.MessageDao;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private MessageDao messageDao;

    @GetMapping("/")
    public String greeting(){
        return "home";
    }


//    @GetMapping("/")
//    public String main(Model model){
//        model.addAttribute("myKey", "myValue");
//        return "main";
//    }


}