package com.service;

import com.model.Posts;
import com.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.awt.image.AreaAveragingScaleFilter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository repository;
    public List<Posts> getPosts() {
        return repository.getPosts();
        }
    public ArrayList<Posts> getOnePost() {
        ArrayList<Posts> latestPost = new ArrayList<>();
        latestPost.add(repository.getLatestPost());
        return latestPost;

}
    public void createPost(Posts newPost) {
        newPost.setDate(new Date());
       repository.createPost(newPost);
       System.out.println("NEW POST:" + newPost);
    }

    public Posts getPost(Integer postId) {
        return repository.getPost(postId);
    }

    public void updatePost(Posts updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }
    public void deletePost(Integer postId) {
        repository.deletePost(postId);
    }
}
