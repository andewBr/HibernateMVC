package org.example.repository;

import org.example.configurate.HibernateTemplate;
import org.example.model.Post;

import java.util.List;

public class PostRepository implements RepositoryTemplate<Post> {

    @Override
    public Post add(Post post) {
         return (Post) HibernateTemplate.performDatabaseOperation(session -> session.save(post));
    }

    @Override
    public List<Post> list() {
        return HibernateTemplate.performDatabaseOperation(session -> {
            return session.createQuery("FROM Post", Post.class).list();
        });
    }

    @Override
    public Post update(int postId, Post postInput) {
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

    @Override
    public Post remove(int postId) {
        return HibernateTemplate.performDatabaseOperation(session -> {
            Post post = session.get(Post.class, postId);
            if (post != null) {
                session.delete(post);
            }
            return null;
        });
    }


}