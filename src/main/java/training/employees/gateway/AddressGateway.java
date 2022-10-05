package training.employees.gateway;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Gateway
@EnableConfigurationProperties(GatewayProperties.class)
@AllArgsConstructor
public class AddressGateway {

    private GatewayProperties gatewayProperties;
    public ForeignAddressDto findAddressByName(String name){
        return WebClient.create(gatewayProperties.getUrl())
                .get()
                .uri(builder -> builder.path("/api/addresses").queryParam("name",name).build())
                .retrieve()
                .bodyToMono(ForeignAddressDto.class)
                .block();
    }
}
