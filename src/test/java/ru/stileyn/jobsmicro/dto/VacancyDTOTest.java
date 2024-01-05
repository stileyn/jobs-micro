package ru.stileyn.jobsmicro.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VacancyDTOTest {

    @Test
    void testVacancyDTO() {
        VacancyDTO vacancyDTO = new VacancyDTO();
        vacancyDTO.setId(1L);
        vacancyDTO.setTitle("Software Engineer");

        assertEquals(1L, vacancyDTO.getId());
        assertEquals("Software Engineer", vacancyDTO.getTitle());
    }
}
