package ua.com.ebooks.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.ebooks.dao.UserDao;
import ua.com.ebooks.entity.Role;
import ua.com.ebooks.entity.User;

import java.util.Collections;


@Controller
public class RegistrationController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/registration")
    public String registration (){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser (User user, Model model){
        User userFromDb = userDao.findByUsername(user.getUsername());

        if(userFromDb != null){
            model.addAttribute("message", "User exists!");
            return  "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userDao.save(user);
        return "redirect:/login";
    }
}
