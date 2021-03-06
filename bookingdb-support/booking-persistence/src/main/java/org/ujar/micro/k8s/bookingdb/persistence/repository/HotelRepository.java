package org.ujar.micro.k8s.bookingdb.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.ujar.micro.k8s.bookingdb.persistence.entity.Hotel;

public interface HotelRepository
    extends PagingAndSortingRepository<Hotel, Long>, JpaRepository<Hotel, Long> {

  void deleteByHotelId(Long hotelId);
}
