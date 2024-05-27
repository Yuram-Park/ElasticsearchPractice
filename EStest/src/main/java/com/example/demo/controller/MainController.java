package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BreedService;
import com.example.demo.domain.Breed;
import com.example.demo.dto.BreedResponseDto;

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
	
	@RequestMapping("/save")
	public String save(@RequestBody Breed breed) {
		breedService.save(breed);
		return "저장 완료";
	}
	
	@GetMapping("/search/{breed}")
	public List<BreedResponseDto> main(@PathVariable("breed") String name) {
		System.out.println(name);
		return breedService.searchName(name);
	}
}
