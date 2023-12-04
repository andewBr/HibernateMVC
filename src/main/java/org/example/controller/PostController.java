package org.example.controller;

import org.example.model.Post;
import org.example.service.PostService;

import java.time.LocalDateTime;
import java.util.List;

public class PostController {

    private PostService postRepository;

    public PostController() {
        this.postRepository = new PostService();
    }

    public void addPost(Post post) {
        postRepository.add(post);
    }

    public List<Post> listPosts() {
        return postRepository.getList();
    }

    public Post updatePost(int postId, Post postInput) {
        return postRepository.update(postId, postInput);
    }

    public Post removePost(int postId) {
        return postRepository.remove(postId);
    }

    public static void main(String[] args) {
        PostController postController = new PostController();

        Post newPost1 = new Post("NewPost Content", LocalDateTime.now(), LocalDateTime.now());
        Post newPost2 = new Post("NewPost Content", LocalDateTime.now(), LocalDateTime.now());

        postController.addPost(newPost1);
        postController.addPost(newPost2);

        List<Post> posts = postController.listPosts();
        System.out.println("List of Posts: " + posts);

        int postIdToUpdate = 2;
        Post updatedPost = new Post("Updated Post", LocalDateTime.now(), LocalDateTime.now());
        postController.updatePost(postIdToUpdate, new Post());

        System.out.println("Updated Post: " + updatedPost);

        int postIdToRemove = 1;
        Post removedPost = postController.removePost(postIdToRemove);
        System.out.println("Removed Post: " + removedPost);
    }
}