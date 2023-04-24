package com.tunahan.market.entities.address;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
public class City extends BaseAddress{

  @ManyToOne
  @JoinColumn(name = "country_id")
  private Country country;
  
  @OneToMany(mappedBy = "city")
  private List<District> districtList;
}
