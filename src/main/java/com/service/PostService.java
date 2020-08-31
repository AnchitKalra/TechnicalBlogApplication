package com.service;

import com.model.Posts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {

    public ArrayList<Posts> getPosts() {
    ArrayList<Posts> postsArrayList = new ArrayList<>();

    Posts post1 = new Posts();
        post1.setTitle("Post1");
        post1.setBody("This is Post 1");
        post1.setDate(new Date());
        postsArrayList.add(post1);

    Posts post2 = new Posts();
        post2.setTitle("Post2");
        post2.setBody("This is Post 2");
        post2.setDate(new Date());
        postsArrayList.add(post2);

    Posts post3 = new Posts();
        post3.setTitle("Post3");
        post3.setBody("This is Post 3");
        post3.setDate(new Date());
        postsArrayList.add(post3);
        return postsArrayList;
}
public ArrayList<Posts> getOnePost() {
        ArrayList<Posts> postsArrayList = new ArrayList<>();
    Posts post1 = new Posts();
    post1.setTitle("User's Post");
    post1.setBody("This is your Post 1");
    post1.setDate(new Date());
    postsArrayList.add(post1);
    return postsArrayList;

}
}
