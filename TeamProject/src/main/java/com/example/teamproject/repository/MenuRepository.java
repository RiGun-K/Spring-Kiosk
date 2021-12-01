package com.example.teamproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.teamproject.data.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> { 

// DAO 기능 ( DB에 접속, 명령 기능 클래스 )


}

