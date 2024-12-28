package com.example.formsaz.controller;

import com.example.formsaz.model.dto.*;
import com.example.formsaz.serivce.FormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forms")
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping
    public ResponseEntity<List<FormResponseDto>> getAllForms() {
        return ResponseEntity.ok(formService.getAllForms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormResponseDto> getFormById(@PathVariable Long id) {
        return ResponseEntity.ok(formService.getFormById(id));
    }

    @PostMapping
    public ResponseEntity<FormResponseDto> createForm(@RequestBody CreateFormRequestDto formDto) {
        return ResponseEntity.ok(formService.createForm(formDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForm(@PathVariable Long id) {
        formService.deleteForm(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormResponseDto> updateForm(@PathVariable Long id,
                                                      @RequestBody UpdateFormRequestDto updatedFormDto) {
        return ResponseEntity.ok(formService.updateForm(id, updatedFormDto));
    }

    @PutMapping("/{id}/publish")
    public ResponseEntity<FormResponseDto> togglePublishForm(@PathVariable Long id) {
        return ResponseEntity.ok(formService.togglePublishForm(id));
    }

    @GetMapping("/published")
    public ResponseEntity<List<FormResponseDto>> getPublishedForms() {
        return ResponseEntity.ok(formService.getPublishedForms());
    }

    @GetMapping("/{id}/fields")
    public ResponseEntity<List<FieldResponseDto>> getFieldsByFormId(@PathVariable Long id) {
        return ResponseEntity.ok(formService.getFieldsByFormId(id));
    }

    @PutMapping("/{id}/fields")
    public ResponseEntity<List<FieldResponseDto>> updateFieldsByFormId(@PathVariable Long id,
                                                                       @RequestBody List<FieldRequestDto> fieldDtos) {
        return ResponseEntity.ok(formService.updateFieldsByFormId(id, fieldDtos));
    }
}