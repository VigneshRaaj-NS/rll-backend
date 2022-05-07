package com.instabus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instabus.entity.Passenger;

@Repository
public interface PassengerDao extends JpaRepository<Passenger, Integer> {

}
