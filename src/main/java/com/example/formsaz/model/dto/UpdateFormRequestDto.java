package com.example.formsaz.model.dto;

public record UpdateFormRequestDto(
        String name,
        boolean published,
        String submitUrl
) {
}
