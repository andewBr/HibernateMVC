package org.example.repository;

import org.example.configurate.HibernateTemplate;
import org.example.model.Label;

import java.util.List;

public class LabelRepository {

    public void addLabel(Label label) {
        HibernateTemplate.performDatabaseOperation(session -> {
            return session.save(label);
        });
    }

    public List<Label> listLabels() {
        return HibernateTemplate.performDatabaseOperation(session -> {
            return session.createQuery("FROM Label", Label.class).list();
        });
    }

    public Label updateLabel(int labelId, Label labelParam) {
        return HibernateTemplate.performDatabaseOperation(session -> {
            Label label = session.get(Label.class, labelId);
            if (label != null) {
                label.setName(labelParam.getName());
                session.update(label);
            }
            return label;
        });
    }


    public Label removeLabel(int labelId) {
        return HibernateTemplate.performDatabaseOperation(session -> {
            Label label = session.get(Label.class, labelId);
            if (label != null) {
                session.delete(label);
            }
            return label;
        });
    }

}
