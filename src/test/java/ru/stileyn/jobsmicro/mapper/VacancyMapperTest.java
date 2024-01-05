package ru.stileyn.jobsmicro.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.stileyn.jobsmicro.dto.VacancyDTO;
import ru.stileyn.jobsmicro.entity.Vacancy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VacancyMapperTest {

    private VacancyMapper vacancyMapper = Mappers.getMapper(VacancyMapper.class);

    @Test
    void testVacancyToVacancyDTO() {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(1L);
        vacancy.setTitle("Software Engineer");

        VacancyDTO vacancyDTO = vacancyMapper.vacancyToVacancyDTO(vacancy);

        assertEquals(vacancy.getId(), vacancyDTO.getId());
        assertEquals(vacancy.getTitle(), vacancyDTO.getTitle());
    }

    @Test
    void testVacancyDTOToVacancy() {
        VacancyDTO vacancyDTO = new VacancyDTO();
        vacancyDTO.setId(1L);
        vacancyDTO.setTitle("Software Engineer");

        Vacancy vacancy = vacancyMapper.vacancyDTOToVacancy(vacancyDTO);

        assertEquals(vacancyDTO.getId(), vacancy.getId());
        assertEquals(vacancyDTO.getTitle(), vacancy.getTitle());
    }
}
