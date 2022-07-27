package org.ujar.micro.k8s.bookingdb.edge.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.ujar.micro.k8s.bookingdb.edge.config.ServicesProperties;
import org.ujar.micro.k8s.bookingdb.edge.model.CityPage;
import org.ujar.micro.k8s.bookingdb.edge.model.CountryPage;
import org.ujar.micro.k8s.bookingdb.edge.model.HotelPage;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class DashboardService {
  private final ServicesProperties properties;
  private final WebClient httpClient;

  public Mono<CountryPage> countries() {
    return httpClient.get()
        .uri(properties.dashboardService("/api/v1/countries"))
        .retrieve()
        .bodyToMono(CountryPage.class);
  }

  public Mono<CityPage> cities() {
    return httpClient.get()
        .uri(properties.dashboardService("/api/v1/cities"))
        .retrieve()
        .bodyToMono(CityPage.class);
  }

  public Mono<HotelPage> hotels() {
    return httpClient.get()
        .uri(properties.dashboardService("/api/v1/hotels"))
        .retrieve()
        .bodyToMono(HotelPage.class);
  }
}
