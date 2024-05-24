package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BreedService;
import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {

	//private final PostRepository postRepository;
	
	private final BreedService breedService;
	
//	@RequestMapping("/api/post")
//	public List<Post> main() {
//		System.out.println("hi");
//		return postRepository.getAll();
//	}
	
	@RequestMapping("/search")
	public String main() {
		System.out.println("hi");
		breedService.searchName("HOUND");
		return "Hello";
	}
}