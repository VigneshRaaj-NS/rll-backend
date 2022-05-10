package com.busManagement.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user",schema = "bus")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
	
	@Nullable
	@Id
	private Integer userId;
	
	@NotNull(message = "username cannot be null")
	private String userName;
	
	
	@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "password cannot be null")
	private String password;
	
	@NotNull(message = "phone cannot be null")
	private Long phone;
	
	@NotBlank(message = "email cannot be null")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL) //One user can make many bookings
	@JoinColumn(name = "user_id") //user_id column will be merged into BookingDetails Entity
	private List<BookingDetails> bookingDetails = new ArrayList<BookingDetails>();


}
