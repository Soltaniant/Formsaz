package com.example.formsaz.serivce;

import com.example.formsaz.mapper.FormMapper;
import com.example.formsaz.model.Form;
import com.example.formsaz.model.dto.*;
import com.example.formsaz.repository.FormRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormService {

    private final FormRepository formRepository;

    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public List<FormResponseDto> getAllForms() {
        return formRepository.findAll().stream()
                .map(FormMapper::toResponse)
                .toList();
    }

    public FormResponseDto createForm(CreateFormRequestDto formDto) {
        Form form = FormMapper.toEntity(formDto);
        return FormMapper.toResponse(formRepository.save(form));
    }

    public FormResponseDto getFormById(Long id) {
        Form form = getForm(id);
        return FormMapper.toResponse(form);
    }

    public FormResponseDto updateForm(Long id, UpdateFormRequestDto updatedFormDto) {
        Form existingForm = getForm(id);
        Form updatedForm = FormMapper.updateEntity(existingForm, updatedFormDto);
        return FormMapper.toResponse(formRepository.save(updatedForm));
    }

    public void deleteForm(Long id) {
        if (!formRepository.existsById(id)) {
            throw new EntityNotFoundException("Form not found with id %d".formatted(id));
        }
        formRepository.deleteById(id);
    }

    public List<FieldResponseDto> getFieldsByFormId(Long id) {
        Form form = getForm(id);
        return form.getFields().stream()
                .map(FormMapper::toResponse)
                .toList();
    }

    @Transactional
    public List<FieldResponseDto> updateFieldsByFormId(Long id, List<FieldRequestDto> fieldDtos) {
        Form form = getForm(id);
        form.setFields(fieldDtos.stream().map(FormMapper::toEntity).toList());
        return form.getFields().stream()
                .map(FormMapper::toResponse)
                .toList();
    }

    public FormResponseDto togglePublishForm(Long id) {
        Form form = getForm(id);
        form.setPublished(!form.isPublished());
        return FormMapper.toResponse(formRepository.save(form));
    }

    public List<FormResponseDto> getPublishedForms() {
        return formRepository.findByPublishedTrue().stream()
                .map(FormMapper::toResponse)
                .toList();
    }

    private Form getForm(Long id) {
        return formRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Form not found with id %d".formatted(id)));
    }
}
