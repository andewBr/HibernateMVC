package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime  updated;

    @ManyToMany
    @JoinTable(
            name = "Post_Label",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id")
    )
    private List<Label> labels;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Writer writer;

    public Post() {
    }

    public Post(String content, LocalDateTime created, LocalDateTime updated) {
        this.content = content;
        this.created = created;
        this.updated = updated;
    }

    public Post(String content, LocalDateTime created, LocalDateTime updated, List<Label> labels) {
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
    }


    public Post(String content, LocalDateTime created, LocalDateTime updated, List<Label> labels, Writer writer) {
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
        this.writer = writer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}

