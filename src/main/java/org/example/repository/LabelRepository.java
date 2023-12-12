package org.example.repository;

import org.example.configurate.HibernateTemplate;
import org.example.model.Label;

import java.util.List;

public class LabelRepository implements RepositoryTemplate<Label> {

    @Override
    public Label add(Label label) {
        return HibernateTemplate.performDatabaseOperation(session -> session.merge(label));
    }

    @Override
    public List<Label> list() {
        return HibernateTemplate.performDatabaseOperation(session -> {
            return session.createQuery("FROM Label", Label.class).list();
        });
    }

    @Override
    public Label update(int labelId, Label entityParam) {
        return HibernateTemplate.performDatabaseOperation(session -> {
            Label label = session.get(Label.class, labelId);
            if (label != null) {
                label.setName(entityParam.getName());
                session.update(label);
            }
            return label;
        });
    }

    public Label remove(int labelId) {
        return HibernateTemplate.performDatabaseOperation(session -> {
            Label label = session.get(Label.class, labelId);
            if (label != null) {
                session.delete(label);
            }
            return label;
        });
    }
}
