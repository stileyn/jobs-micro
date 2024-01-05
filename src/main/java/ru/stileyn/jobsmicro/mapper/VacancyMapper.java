package ru.stileyn.jobsmicro.mapper;

import ru.stileyn.jobsmicro.dto.VacancyDTO;
import ru.stileyn.jobsmicro.entity.Vacancy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VacancyMapper {
    VacancyDTO vacancyToVacancyDTO(Vacancy vacancy);
    Vacancy vacancyDTOToVacancy(VacancyDTO vacancyDTO);
}
