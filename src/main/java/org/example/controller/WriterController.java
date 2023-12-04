package org.example.controller;

import org.example.model.Label;
import org.example.model.Post;
import org.example.model.Writer;
import org.example.service.WriterService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WriterController {

    private WriterService writerService;

    public WriterController() {
        this.writerService = new WriterService();
    }

    public void addWriter(Writer writer) {
        writerService.add(writer);
    }

    public List<Writer> listWriters() {
        return writerService.getList();
    }

    public Writer updateWriter(int writerId, Writer writerInput) {
        return writerService.update(writerId, writerInput);
    }

    public Writer removeWriter(int writerId) {
        return writerService.remove(writerId);
    }

    public static void main(String[] args) {
        WriterController writerController = new WriterController();

        // Example: Adding a writer

        List<Post> postForWriter1 = Collections.singletonList(new Post("post1", LocalDateTime.now(), LocalDateTime.now()));
        List<Post> postForWriter2 = Collections.singletonList(new Post("post1", LocalDateTime.now(), LocalDateTime.now()));
        List<Post> postForWriter3 = Collections.singletonList(new Post("post1", LocalDateTime.now(), LocalDateTime.now()));
        Writer writer1 = new Writer("Andrew", "Burov");
        Writer writer2 = new Writer("Anait", "Burova");
        Writer writer3 = new Writer("Evgeniy", "Suleymanov");

        writer1.setPosts(postForWriter1);
        writer1.setPosts(postForWriter2);
        writer1.setPosts(postForWriter3);

//        Writer newWriter = new Writer("John", "Doe");
        writerController.addWriter(writer1);
        writerController.addWriter(writer2);
        writerController.addWriter(writer3);

        // Example: Listing writers
        List<Writer> writers = writerController.listWriters();
        System.out.println("List of Writers: " + writers);

        // Example: Updating a writer
        int writerIdToUpdate = 1; // Replace with the actual writer ID

        List<Post> postForWriter1_1 = Collections.singletonList(new Post("post1", LocalDateTime.now(), LocalDateTime.now()));
        Writer writer1_1 = new Writer("Andrew", "Burov");
        writer1_1.setPosts(postForWriter1_1);

        Writer updatedWriter = writerController.updateWriter(writerIdToUpdate, writer1_1);
        System.out.println("Updated Writer: " + updatedWriter);

        // Example: Removing a writer
        int writerIdToRemove = 2; // Replace with the actual writer ID
        Writer removedWriter = writerController.removeWriter(writerIdToRemove);
        System.out.println("Removed Writer: " + removedWriter);
    }
}