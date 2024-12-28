package com.example.formsaz.model.dto;

import com.example.formsaz.model.FieldType;

public record FieldResponseDto(
        Long id,
        String name,
        String label,
        FieldType type,
        String defaultValue
) {
}