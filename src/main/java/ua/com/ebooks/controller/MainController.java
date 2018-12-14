package ua.com.ebooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.ebooks.dao.MessageDao;
import ua.com.ebooks.entity.Message;

@Controller
public class MainController {

    @Autowired
    private MessageDao messageDao;

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("messages", messageDao.findAll());
        return "main";
    }

    @PostMapping("/main")
    public String main(@RequestParam String text, @RequestParam String tag, Model model) {
        System.out.println(text);
        System.out.println(tag);

        Message message = new Message();
        message.setTag(tag);
        message.setText(text);
        messageDao.save(message);

        model.addAttribute("messages", messageDao.findAll());

        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Model model) {

        if(filter != null && !filter.isEmpty()) {
            model.addAttribute("messages", messageDao.findByTag(filter));
        }else {
            model.addAttribute("messages", messageDao.findAll());
        }
        return "main";
    }

}
