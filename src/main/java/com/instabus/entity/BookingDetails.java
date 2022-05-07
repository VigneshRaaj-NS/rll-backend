package com.instabus.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "booking_details",schema = "hr")
@Data @NoArgsConstructor @AllArgsConstructor
public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	
	@Column
	private String bookingDate;
	
	@Column
	private String bookingTime;
	
	@Column
	private Double totalCost;
	
	@Column
	private Integer busNumber;
	
	@Column
	private Integer ownerId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Passenger> passengers = new ArrayList<Passenger>();

}
