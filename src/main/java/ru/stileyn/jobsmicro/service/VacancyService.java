package ru.stileyn.jobsmicro.service;

import ru.stileyn.jobsmicro.dto.VacancyDTO;
import ru.stileyn.jobsmicro.entity.Vacancy;
import ru.stileyn.jobsmicro.mapper.VacancyMapper;
import ru.stileyn.jobsmicro.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;
    private final VacancyMapper vacancyMapper;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository, VacancyMapper vacancyMapper) {
        this.vacancyRepository = vacancyRepository;
        this.vacancyMapper = vacancyMapper;
    }

    public List<VacancyDTO> getAllVacancies() {
        List<Vacancy> vacancies = vacancyRepository.findAll();
        return vacancies.stream()
                .map(vacancyMapper::vacancyToVacancyDTO)
                .collect(Collectors.toList());
    }

    public VacancyDTO createVacancy(VacancyDTO vacancyDTO) {
        Vacancy vacancy = vacancyMapper.vacancyDTOToVacancy(vacancyDTO);
        Vacancy savedVacancy = vacancyRepository.save(vacancy);
        return vacancyMapper.vacancyToVacancyDTO(savedVacancy);
    }

    // Другие методы для обновления, удаления вакансий и т.д.
}
