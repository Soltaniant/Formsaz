package com.example.formsaz.model.dto;

import com.example.formsaz.model.FieldType;

public record FieldRequestDto(
        String name,
        String label,
        FieldType type,
        String defaultValue
) {
}
