package com.example.formsaz.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String label;

    @Enumerated
    private FieldType type;

    private String defaultValue;
}
