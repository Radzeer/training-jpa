package training.employees.gateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "gateway")
@Data
public class GatewayProperties {

    private String url;
}
