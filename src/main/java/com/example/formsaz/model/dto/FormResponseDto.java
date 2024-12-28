package com.example.formsaz.model.dto;

public record FormResponseDto(
        Long id,
        String name,
        boolean published,
        String submitUrl
) {
}
