package com.controller;

import com.model.Posts;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    PostService postService;
    @RequestMapping("posts")
    public String getPost(Model model) {
        ArrayList<Posts> posts = postService.getOnePost();
        model.addAttribute("posts", posts);
        return "posts";

    }
    @RequestMapping("controller/createpost")
    public String createPost() {
        return "createpost";
    }
    @RequestMapping(value = "controller/createpost", method = RequestMethod.POST)
    public String createPost(Posts post, Model model) {
        if(post!=null) {
            model.addAttribute("posts", post);
            return "posts";
        }
        return "createpost";
    }
}
