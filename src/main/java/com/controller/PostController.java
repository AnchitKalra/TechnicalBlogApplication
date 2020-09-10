package com.controller;

import com.model.Posts;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {


    @Autowired
    PostService postService;
    @RequestMapping("posts")
    public String getPost(Model model) {
        List<Posts> latestPost = postService.getPosts();
        model.addAttribute("posts", latestPost);
        return "posts";

    }
    @RequestMapping("controller/createpost")
    public String createPost() {
        return "createpost";
    }
    @RequestMapping(value = "controller/createpost", method = RequestMethod.POST)
    public String createPost(Posts post) {
        postService.createPost(post);
           // return "posts";
       // System.out.println("New Post: "+post);
        return "redirect:/posts";
    }
    @RequestMapping(value = "/editPost", method = RequestMethod.GET)
    public String editPost(@RequestParam(name = "postId") Integer postId, Model model) {
        Posts post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.PUT)
    public String editPost(@RequestParam(name = "postId") Integer postId, Posts updatedPost) {
        updatedPost.setId(postId);
        postService.updatePost(updatedPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.DELETE)
    public String deletePost(@RequestParam(name = "postId") Integer postId) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }
}
