package com.carrental.backend.car.domain;

import com.carrental.backend.borrows.domain.Borrows;
import com.carrental.backend.user.domain.User;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String brand;
  private String model;

  private double engineCapacity;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  private Date createDate;

  private Date updateDate;

  private Date deleteDate;

  @ManyToMany
  @JoinTable(name = "car_borrow",
      joinColumns = {@JoinColumn(name = "car_id")},
      inverseJoinColumns = {@JoinColumn(name = "borrow_id")})
  private Set<Borrows> borrows;

}
