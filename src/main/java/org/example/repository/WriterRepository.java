package org.example.repository;

import org.example.configurate.HibernateTemplate;
import org.example.model.Writer;

import java.util.List;

public class WriterRepository {

    public void addWriter(Writer writer) {
        HibernateTemplate.performDatabaseOperation(session -> {
            return session.save(writer);
        });
    }

    public List<Writer> listWriters() {
        return HibernateTemplate.performDatabaseOperation(session -> {
            return session.createQuery("FROM Writer", Writer.class).list();
        });
    }

    public Writer updateWriter(int writerId, Writer writerInput) {
        return HibernateTemplate.performDatabaseOperation(session -> {
            Writer writer = session.get(Writer.class, writerId);
            if (writer != null) {
                writer.setFirstName(writerInput.getFirstName());
                writer.setLastName(writerInput.getLastName());
            }
            session.update(writer);
            return writer;
        });
    }

    public Writer removeWriter(int writerId) {
        return HibernateTemplate.performDatabaseOperation(session -> {
            Writer writer = session.get(Writer.class, writerId);
            if (writer != null) {
                session.delete(writer);
            }
            return writer;
        });
    }
}
