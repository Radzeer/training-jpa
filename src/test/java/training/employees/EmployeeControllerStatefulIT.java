package training.employees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import training.employees.employees.dto.CreateEmployeeCommand;
import training.employees.employees.dto.EmployeeDetailsDto;
import training.employees.employees.repository.AddressesRepository;
import training.employees.employees.repository.EmployeesRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Sql(statements = "delete from addresses; delete from employees")
public class EmployeeControllerStatefulIT {

    @Autowired
    WebTestClient webClient;

    @Autowired
    EmployeesRepository repository;

    @Autowired
    AddressesRepository addressesRepository;


    @BeforeEach
    void deleteAll(){
        addressesRepository.deleteAll();
        repository.deleteAll();
    }

    @Test
    void testCreateEmployee(){
            var result = webClient
                    .post()
                    .uri("/api/employees")
                    .bodyValue(new CreateEmployeeCommand("Amber Doe", 1970, 0))
                    .exchange()
                    .expectStatus().isCreated()
                    .expectBody(EmployeeDetailsDto.class)
                    .returnResult().getResponseBody();
            ;
             webClient
                    .get()
                    .uri("/api/employees/")
                    .exchange()
                    .expectBodyList(EmployeeDetailsDto.class)
                    .hasSize(1);

    }
}
