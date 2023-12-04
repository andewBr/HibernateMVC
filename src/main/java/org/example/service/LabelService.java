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
        labelRepository.addLabel(label);
    }

    @Override
    public List<Label> getList() {
        return labelRepository.listLabels();
    }

    @Override
    public Label update(int modelId, Label label) {
        return labelRepository.updateLabel(modelId, label);
    }

    @Override
    public Label remove(int modelId) {
        return labelRepository.removeLabel(modelId);
    }
}


