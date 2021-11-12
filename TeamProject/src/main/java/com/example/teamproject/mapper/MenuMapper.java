package com.example.teamproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.teamproject.data.Menu;

@Mapper
public interface MenuMapper {

	// SQL 문 작성
	@Select("select * from menu")
	public List<Menu> findAll();
	
}
