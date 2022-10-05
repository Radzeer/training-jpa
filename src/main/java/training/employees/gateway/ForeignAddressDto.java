package training.employees.gateway;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForeignAddressDto {
    private String city;

    private String address;
}
