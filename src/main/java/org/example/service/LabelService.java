package org.example.service;

import org.example.model.Label;
import org.example.repository.LabelRepository;

import java.util.List;

public class LabelService implements TemplateService<Label> {

    private LabelRepository labelRepository;

    public LabelService() {
        this.labelRepository = new LabelRepository();
    }

    @Override
    public void add(Label label) {
        labelRepository.add(label);
    }

    @Override
    public List<Label> getList() {
        return labelRepository.list();
    }

    @Override
    public Label update(int modelId, Label label) {
        return labelRepository.update(modelId, label);
    }

    @Override
    public Label remove(int modelId) {
        return labelRepository.remove(modelId);
    }
}


