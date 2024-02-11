package com.reservo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "state")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StateEntity extends BaseEntity{
	
	@OneToMany(mappedBy = "state")
	private List<CityEntity> cities = new ArrayList<CityEntity>();
	
	@Column(name="state_name", nullable = false)
	private String stateName;
}
