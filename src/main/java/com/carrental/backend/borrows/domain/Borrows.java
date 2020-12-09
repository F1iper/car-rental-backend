package com.carrental.backend.borrows.domain;

import com.carrental.backend.car.domain.Car;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Borrows {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;


  @ManyToMany(mappedBy = "borrows")
  private Set<Car> cars;

  private Date borrowDate;
  private Date updateDate;
  private Date returnDate;

}
