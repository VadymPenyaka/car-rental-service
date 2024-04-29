package nulp.cs.carrentalrestservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import nulp.cs.carrentalrestservice.mapper.AdminMapper;
import nulp.cs.carrentalrestservice.model.AdminDTO;
import nulp.cs.carrentalrestservice.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AdminControllerIT {
    @Autowired
    private AdminController adminController;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void getAllAdminsTest() {
        List<AdminDTO> adminDTOS = adminController.getAllAdmins();

        assertThat(adminDTOS.size()).isNotEqualTo(0);
    }

    @Test
    @Rollback
    @Transactional
    void createAdminTest () {
        AdminDTO adminDTO = adminMapper
                .adminToAdminDto(adminRepository
                .findAll().get(0));

        ResponseEntity responseEntity = adminController.createAdmin(adminDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));

    }

    @Test
    void getAdminByIdTest () {
        AdminDTO expected = adminMapper.adminToAdminDto(adminRepository.findAll().get(0));

        AdminDTO foundAdmin = adminController.getAdminById(expected.getId());

        assertThat(foundAdmin).isEqualTo(expected);
    }


}