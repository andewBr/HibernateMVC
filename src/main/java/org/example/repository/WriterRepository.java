package org.example.repository;

import org.example.configurate.HibernateTemplate;
import org.example.model.Writer;

import java.util.List;

public class WriterRepository implements RepositoryTemplate<Writer> {

    public Writer add(Writer writer) {
        return (Writer) HibernateTemplate.performDatabaseOperation(session -> session.save(writer));
    }

    public List<Writer> list() {
        return HibernateTemplate.performDatabaseOperation(session -> {
            return session.createQuery("FROM Writer", Writer.class).list();
        });
    }

    public Writer update(int writerId, Writer writerInput) {
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

    public Writer remove(int writerId) {
        return HibernateTemplate.performDatabaseOperation(session -> {
            Writer writer = session.get(Writer.class, writerId);
            if (writer != null) {
                session.delete(writer);
            }
            return writer;
        });
    }
}
