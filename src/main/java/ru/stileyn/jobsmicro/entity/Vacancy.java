package ru.stileyn.jobsmicro.entity;

import jakarta.persistence.*;
import lombok.Data;

//import javax.persistence.*;

@Entity
@Table(name = "vacancies")
@Data
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    // Другие поля вакансии
}
