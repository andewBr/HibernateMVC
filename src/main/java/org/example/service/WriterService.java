package org.example.service;

import org.example.model.Writer;
import org.example.repository.WriterRepository;

import java.util.List;

public class WriterService implements TemplateService<Writer> {

    private WriterRepository writerRepository;

    public WriterService() {
        this.writerRepository = new WriterRepository();
    }

    @Override
    public void add(Writer writer) {
        writerRepository.add(writer);
    }

    @Override
    public List<Writer> getList() {
        return writerRepository.list();
    }

    @Override
    public Writer update(int modelId, Writer model) {
        return writerRepository.update(modelId, model);
    }

    @Override
    public Writer remove(int modelId) {
        return writerRepository.remove(modelId);
    }
}
