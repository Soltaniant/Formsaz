package com.example.formsaz.model.dto;

import java.util.List;

public record CreateFormRequestDto(
        String name,
        boolean published,
        List<FieldRequestDto> fields,
        String submitUrl
) {
}


