package org.example.controller;

import org.example.model.Label;
import org.example.service.LabelService;

import java.util.List;

public class LabelController {
    private LabelService labelRepository;

    public LabelController() {
        this.labelRepository = new LabelService();
    }

    public void addLabel(Label label) {
        labelRepository.add(label);
    }

    public List<Label> listLabels() {
        return labelRepository.getList();
    }

    public Label updateLabel(int labelId, Label labelParam) {
        return labelRepository.update(labelId, labelParam);
    }

    public Label removeLabel(int labelId) {
        return labelRepository.remove(labelId);
    }

    public static void main(String[] args) {
        LabelController labelController = new LabelController();

        Label newLabel = new Label("NewLabel");
        labelController.addLabel(newLabel);

        List<Label> labels = labelController.listLabels();
        System.out.println("List of Labels: " + labels);

        int labelIdToUpdate = 1;
        Label updatedLabel = labelController.updateLabel(labelIdToUpdate, new Label("UpdatedLabel"));
        System.out.println("Updated Label: " + updatedLabel);

        int labelIdToRemove = 2;
        Label removedLabel = labelController.removeLabel(labelIdToRemove);
        System.out.println("Removed Label: " + removedLabel);
    }
}