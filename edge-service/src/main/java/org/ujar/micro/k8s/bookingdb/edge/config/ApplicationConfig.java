package org.ujar.micro.k8s.bookingdb.edge.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties(ServicesProperties.class)
class ApplicationConfig {

  @Bean
  WebClient webClient(WebClient.Builder builder) {
    return builder.build();
  }
}
