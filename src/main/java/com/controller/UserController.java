package com.controller;

import com.model.Posts;
import com.model.User;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    PostService postService;
    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }
    @RequestMapping("users/register")
    public String register() {
        return "users/register";
    }
    @RequestMapping(value = "users/login", method =RequestMethod.POST)
    public String loginUser(User user) {

        return "redirect:/posts";
    }
    @RequestMapping(value = "users/logout", method =RequestMethod.POST)
    public String logoutUser(Model model) {
        ArrayList<Posts> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
