package com.tunahan.market.entities.address;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
public class Country extends BaseAddress{
	
	@OneToMany(mappedBy = "country")
	List<City> cityList;
}
