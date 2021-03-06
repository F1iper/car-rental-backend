package com.carrental.backend.user.domain;

import com.carrental.backend.car.domain.Car;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String firstname;
  private String lastname;
  private String email;
  private String password;

  @OneToMany(mappedBy = "user")
  private Set<Car> cars;

  @CreatedDate
  private Date createdAt;
  private Date updatedAt;
  private Date deletedAt;
}
