package ru.stileyn.jobsmicro.dto;

import lombok.Data;

@Data
public class VacancyDTO {
    private Long id;
    private String title;
    private String description;
    // Другие поля вакансии для передачи на фронт
}
