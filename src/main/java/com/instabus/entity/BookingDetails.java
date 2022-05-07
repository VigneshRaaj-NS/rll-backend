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
@Table(name = "booking_details",schema = "bus")
@Data @NoArgsConstructor @AllArgsConstructor
public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	
	
	private String bookingDate;
	
	
	private String bookingTime;
	
	private Double totalCost;
	
	private Integer busNumber;
	
	private Integer ownerId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Passenger> passengers = new ArrayList<Passenger>();

}
