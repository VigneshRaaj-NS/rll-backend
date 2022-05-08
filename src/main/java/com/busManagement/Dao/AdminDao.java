package com.busManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busManagement.entity.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

}
