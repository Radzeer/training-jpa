package training.employees.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import training.employees.gateway.ForeignAddressDto;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EmployeeDetailsDto {

    private Long id;

    private String name;

    private int yearOfBirth;

    private LocalDateTime created;

    private SpecialAddressDto address;
}
