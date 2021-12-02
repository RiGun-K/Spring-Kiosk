package com.example.teamproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teamproject.data.Ordered;

public interface OrderedRepository extends JpaRepository<Ordered, String> {

}
