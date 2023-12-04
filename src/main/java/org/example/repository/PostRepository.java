package org.example.repository;

import org.example.configurate.HibernateTemplate;
import org.example.model.Post;

import java.util.List;

public class PostRepository {

    public void addPost(Post post) {
         HibernateTemplate.performDatabaseOperation(session -> {
             return session.save(post);
        });
    }

    public List<Post> listPosts() {
        return HibernateTemplate.performDatabaseOperation(session -> {
            return session.createQuery("FROM Post", Post.class).list();
        });
    }

    public Post updatePost(int postId, Post postInput) {
        return HibernateTemplate.performDatabaseOperation(session -> {
            Post post = session.get(Post.class, postId);
            if (post != null) {
                post.setContent(postInput.getContent());
                post.setCreated(postInput.getCreated());
                post.setUpdated(postInput.getUpdated());
                post.setLabels(postInput.getLabels());
            }
            session.update(post);

            return post;
        });
    }

    public Post removePost(int postId) {
        return HibernateTemplate.performDatabaseOperation(session -> {
            Post post = session.get(Post.class, postId);
            if (post != null) {
                session.delete(post);
            }
            return null;
        });
    }


}