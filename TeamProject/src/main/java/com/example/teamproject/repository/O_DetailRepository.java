package com.example.teamproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teamproject.data.O_Detail;

@Repository
public interface O_DetailRepository extends JpaRepository<O_Detail, String> {

}
