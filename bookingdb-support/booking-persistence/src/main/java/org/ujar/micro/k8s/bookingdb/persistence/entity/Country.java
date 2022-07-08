package org.ujar.micro.k8s.bookingdb.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Country.TABLE_NAME)
public class Country {

  protected static final String TABLE_NAME = "countries";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String country;

  @Override
  public String toString() {
    return "Country{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", country='" + country + '\'' +
           '}';
  }
}