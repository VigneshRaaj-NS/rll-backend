package com.instabus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instabus.entity.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

}
