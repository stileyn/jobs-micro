package ru.stileyn.jobsmicro.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.stileyn.jobsmicro.dto.VacancyDTO;
import ru.stileyn.jobsmicro.service.VacancyService;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VacancyController.class)
class VacancyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VacancyService vacancyService;

    @Test
    void testGetAllVacancies() throws Exception {
        VacancyDTO vacancyDTO = new VacancyDTO();
        vacancyDTO.setId(1L);

        when(vacancyService.getAllVacancies()).thenReturn(Collections.singletonList(vacancyDTO));

        mockMvc.perform(get("/api/vacancies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1));

        verify(vacancyService, times(1)).getAllVacancies();
    }

    @Test
    void testCreateVacancy() throws Exception {
        VacancyDTO vacancyDTO = new VacancyDTO();
        vacancyDTO.setId(1L);

        when(vacancyService.createVacancy(any(VacancyDTO.class))).thenReturn(vacancyDTO);

        mockMvc.perform(post("/api/vacancies")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));

        verify(vacancyService, times(1)).createVacancy(any(VacancyDTO.class));
    }

    // Другие тесты для обновления, удаления вакансий и т.д.
}
