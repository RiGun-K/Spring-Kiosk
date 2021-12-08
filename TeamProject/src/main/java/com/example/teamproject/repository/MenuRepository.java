package com.example.teamproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.teamproject.data.Kind;
import com.example.teamproject.data.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
	
	
	List<Menu> findByKind(Kind kind);
}

