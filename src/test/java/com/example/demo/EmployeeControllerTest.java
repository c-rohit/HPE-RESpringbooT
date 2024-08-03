package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeManager employeeManager;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        Employee employee1 = new Employee(1, "John", "Doe", "john.doe@example.com", "Developer");
        Employee employee2 = new Employee(2, "Jane", "Smith", "jane.smith@example.com", "Manager");

        List<Employee> employees = Arrays.asList(employee1, employee2);

        when(employeeManager.getEmployees().getEmployeeList()).thenReturn(employees);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/employees")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(200);

        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content).contains("John", "Doe", "Jane", "Smith");
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee employee = new Employee(3, "Emily", "Johnson", "emily.johnson@example.com", "Designer");

        String json = "{ \"employeeId\": 3, \"firstName\": \"Emily\", \"lastName\": \"Johnson\", \"email\": \"emily.johnson@example.com\", \"title\": \"Designer\" }";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andReturn();

        assertThat(employeeManager.getEmployees().getEmployeeList()).contains(employee);
    }
}
