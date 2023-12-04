package org.example.service;

import java.util.List;

public interface TemplateService<T> {
    void add(T model);
    List<T> getList();
    T update(int modelId, T model);
    T remove(int modelId);
}
