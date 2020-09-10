package com.controller;

import com.model.Posts;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PostService posts;
    @RequestMapping("/")
        public String homeController(Model model) {
        List<Posts> postsArrayList = posts.getPosts();
        model.addAttribute("posts", postsArrayList);
        return "index";

    }
}
