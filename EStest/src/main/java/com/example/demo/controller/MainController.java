package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BreedService;
import com.example.demo.document.BreedDocument;
import com.example.demo.document.ChosungDocument;
import com.example.demo.document.FuzzyDocument;
import com.example.demo.document.JasoDocument;
import com.example.demo.domain.Breed;
import com.example.demo.dto.BreedResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {
	
	private final BreedService breedService;
	
	@RequestMapping("/save")
	public String save(@RequestBody Breed breed) {
		breedService.save(breed);
		return "저장 완료";
	}
	
	@GetMapping("/search/{breedId}")
	public BreedDocument main(@PathVariable("breedId") int breedId) {
		return breedService.searchName(breedId);
	}
	
	// 한국어 저장 및 검색
	@RequestMapping("/koSave")
	public String koSave(@RequestBody Breed breed) {
		breedService.koSave(breed);
		return "저장 완료";
	}

	@GetMapping("/koSearch/{breed}")
	public List<BreedResponseDto> koSearch(@PathVariable("breed") String name) {
		return breedService.koSearch(name);
	}
	
	// Fuzzy 검색
	@GetMapping("/fuzzySearch/{breed}")
	public List<FuzzyDocument> fuzzySearch(@PathVariable("breed") String name) {
		return breedService.fuzzySearch(name);
	}
	
	
	// 초성 검색(플러그인 도입)
	@PostMapping("/jasoSave")
	public String jasoSave(@RequestBody Breed breed) {
		breedService.jasoSave(breed);
		return "저장 완료";
	}
	
	@GetMapping("/jasoSearch/{breed}")
	public List<JasoDocument> jasoSearch(@PathVariable("breed") String name) {
		return breedService.jasoSearch(name);
	}

	// 초성 검색(플러그인 - 초성 수정)
	@PostMapping("/chosungSave")
	public String chosungSave(@RequestBody Breed breed) {
		breedService.chosungSave(breed);
		return "저장 완료";
	}
	
	@GetMapping("/chosungSearch/{breed}")
	public List<ChosungDocument> chosungSearch(@PathVariable("breed") String name) {
		return breedService.chosungSearch(name);
	}
		
	// 초성 검색(Regexp)
	@GetMapping("/regSearch/{breed}")
	public List<BreedDocument> regSearch(@PathVariable("breed") String name) {
		return breedService.regSearch(name);
	}
	
	// 복합 쿼리(bool) 검색
	@GetMapping("/boolSearch/{breed}")
	public List<BreedDocument> boolSearch(@PathVariable("breed") String name) {
		return breedService.boolSearch(name);
	}
}
