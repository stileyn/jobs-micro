package ru.stileyn.jobsmicro.controller;

import ru.stileyn.jobsmicro.dto.VacancyDTO;
import ru.stileyn.jobsmicro.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vacancies")
public class VacancyController {

    private final VacancyService vacancyService;

    @Autowired
    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping
    public List<VacancyDTO> getAllVacancies() {
        return vacancyService.getAllVacancies();
    }

    @PostMapping
    public VacancyDTO createVacancy(@RequestBody VacancyDTO vacancyDTO) {
        return vacancyService.createVacancy(vacancyDTO);
    }

    // Другие методы для обновления, удаления вакансий и т.д.
}
