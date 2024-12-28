package com.example.formsaz.mapper;

import com.example.formsaz.model.Field;
import com.example.formsaz.model.FieldType;
import com.example.formsaz.model.Form;
import com.example.formsaz.model.dto.CreateFormRequestDto;
import com.example.formsaz.model.dto.FieldRequestDto;
import com.example.formsaz.model.dto.FieldResponseDto;
import com.example.formsaz.model.dto.FormResponseDto;
import com.example.formsaz.model.dto.UpdateFormRequestDto;

public class FormMapper {

    public static FormResponseDto toResponse(Form form) {
        if ( form == null ) {
            return null;
        }

        Long id = form.getId();
        String name = form.getName();
        boolean published = form.isPublished();
        String submitUrl = form.getSubmitUrl();

        return new FormResponseDto( id, name, published, submitUrl );
    }

    
    public static Form toEntity(CreateFormRequestDto formDto) {
        if ( formDto == null ) {
            return null;
        }

        Form form = new Form();
        form.setName(formDto.name());
        form.setPublished(formDto.published());
        form.setSubmitUrl(formDto.submitUrl());
        form.setFields(formDto.fields().stream().map(FormMapper::toEntity).toList());
        return form;
    }

    
    public static Form updateEntity(Form form, UpdateFormRequestDto formDto) {
        if ( formDto == null ) {
            return form;
        }

        form.setName(formDto.name());
        form.setPublished(formDto.published());
        form.setSubmitUrl(formDto.submitUrl());

        return form;
    }

    public static FieldResponseDto toResponse(Field field) {
        if ( field == null ) {
            return null;
        }

        Long id = field.getId();
        String name = field.getName();
        String label = field.getLabel();
        FieldType type = field.getType();
        String defaultValue = field.getDefaultValue();

        return new FieldResponseDto( id, name, label, type, defaultValue );
    }

    
    public static Field toEntity(FieldRequestDto fieldDto) {
        if ( fieldDto == null ) {
            return null;
        }

        Field field = new Field();
        field.setType(fieldDto.type());
        field.setName(fieldDto.name());
        field.setLabel(fieldDto.label());
        field.setDefaultValue(fieldDto.defaultValue());

        return field;
    }
}

