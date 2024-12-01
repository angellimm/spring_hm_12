package com.example.demo.controlers;


import com.example.demo.model.User;
import com.example.demo.service.FileGetAway;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class UserController {

    private FileGetAway fileGetAway;

    private  final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public  String findAll (Model model){
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user=list";
//        return "home.html"
    }

    @GetMapping("/user-create")
    public String createUserFrom(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public  String createUser(User user){
        userService.saveUser(user);
        fileGetAway.writeToFile(user.getName() + ".txt", user.toString());
        return "redirect:/users";
    }
// Удаление пользователя
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/users";
    }
}
