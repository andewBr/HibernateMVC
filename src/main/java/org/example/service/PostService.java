package org.example.service;


import org.example.model.Post;
import org.example.repository.PostRepository;

import java.util.List;

public class PostService implements TemplateService<Post> {

    private PostRepository postRepository;

    public PostService() {
        this.postRepository = new PostRepository();
    }

    @Override
    public void add(Post post) {
        postRepository.add(post);
    }

    @Override
    public List<Post> getList() {
        return postRepository.list();
    }

    @Override
    public Post update(int modelId, Post post) {
        return postRepository.update(modelId, post);
    }

    @Override
    public Post remove(int modelId) {
        return postRepository.remove(modelId);
    }
}
