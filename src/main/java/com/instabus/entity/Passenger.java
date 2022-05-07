package com.instabus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "passengers",schema = "bus")
@Data @NoArgsConstructor @AllArgsConstructor
public class Passenger {
	
	@Id
    private int passengerId;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int age;
	@Column
	private Double luggage;

}
