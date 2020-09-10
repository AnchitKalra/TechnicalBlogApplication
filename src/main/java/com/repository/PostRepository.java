package com.repository;

import com.model.Posts;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {
    @PersistenceUnit(unitName = "TechnicalBlog")
    private EntityManagerFactory entityManagerFactory;

    public List<Posts> getPosts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Posts> query = entityManager.createQuery("select p from Posts p", Posts.class);
        return query.getResultList();
    }
    public Posts getLatestPost() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Posts.class, 4);
    }
    public Posts createPost(Posts newPost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.persist(newPost);
            entityTransaction.commit();
        }
        catch (Exception e){
            entityTransaction.rollback();
        }
        return newPost;
    }
    public Posts getPost(Integer postId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Posts.class, postId);
    }

    public void updatePost(Posts updatedPost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.merge(updatedPost);
            entityTransaction.commit();
        }
        catch (Exception e){
            entityTransaction.rollback();
        }

    }
    public void deletePost(Integer postId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Posts post = entityManager.find(Posts.class, postId);
        try{
            entityTransaction.begin();
            entityManager.remove(post);
            entityTransaction.commit();
        }
        catch (Exception e){
            entityTransaction.rollback();
        }
    }

}
