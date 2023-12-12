package org.example.repository;

import org.example.configurate.HibernateTemplate;
import org.example.model.Label;

import java.util.List;

public interface RepositoryTemplate<T> {
    T add(T label);
    List<T> list();
    T update(int entityId, T entityParam);
    T remove(int entityId);
}
