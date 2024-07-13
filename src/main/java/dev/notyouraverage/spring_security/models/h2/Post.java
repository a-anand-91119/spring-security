package dev.notyouraverage.spring_security.models.h2;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public record Post(@Id Integer id, String title, String content) {

}
