package ru.stileyn.jobsmicro.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.stileyn.jobsmicro.dto.VacancyDTO;
import ru.stileyn.jobsmicro.entity.Vacancy;
import ru.stileyn.jobsmicro.mapper.VacancyMapper;
import ru.stileyn.jobsmicro.repository.VacancyRepository;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class VacancyServiceTest {

    @Mock
    private VacancyRepository vacancyRepository;

    @Mock
    private VacancyMapper vacancyMapper;

    @InjectMocks
    private VacancyService vacancyService;

    @Test
    void testGetAllVacancies() {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(1L);
        VacancyDTO vacancyDTO = new VacancyDTO();
        vacancyDTO.setId(1L);

        when(vacancyRepository.findAll()).thenReturn(Collections.singletonList(vacancy));
        when(vacancyMapper.vacancyToVacancyDTO(vacancy)).thenReturn(vacancyDTO);

        assertEquals(Collections.singletonList(vacancyDTO), vacancyService.getAllVacancies());
        verify(vacancyRepository, times(1)).findAll();
    }

    @Test
    void testCreateVacancy() {
        VacancyDTO vacancyDTO = new VacancyDTO();
        vacancyDTO.setId(1L);
        Vacancy vacancy = new Vacancy();
        vacancy.setId(1L);

        when(vacancyMapper.vacancyDTOToVacancy(vacancyDTO)).thenReturn(vacancy);
        when(vacancyRepository.save(vacancy)).thenReturn(vacancy);
        when(vacancyMapper.vacancyToVacancyDTO(vacancy)).thenReturn(vacancyDTO);

        assertEquals(vacancyDTO, vacancyService.createVacancy(vacancyDTO));
        verify(vacancyRepository, times(1)).save(vacancy);
    }

    // Другие тесты для обновления, удаления вакансий и т.д.
}
