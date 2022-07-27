package org.ujar.micro.k8s.bookingdb.edge.web;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.ujar.micro.k8s.bookingdb.edge.model.CityPage;
import org.ujar.micro.k8s.bookingdb.edge.model.CountryPage;
import org.ujar.micro.k8s.bookingdb.edge.model.HotelPage;
import org.ujar.micro.k8s.bookingdb.edge.service.DashboardService;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class DashboardController {

  private final DashboardService service;

  @QueryMapping
  Mono<CountryPage> countries() {
    return service.countries();
  }

  @QueryMapping
  Mono<CityPage> cities() {
    return service.cities();
  }

  @QueryMapping
  Mono<HotelPage> hotels() {
    return service.hotels();
  }
}
