package com.example.teamproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teamproject.data.Ordered;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered, Integer> {

}
