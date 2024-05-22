package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Post;

@Mapper
public interface PostMapper {
	
	@Select("SELECT * FROM test")
	List<Post> selectAll();
}
