package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.document.BreedDocument;
import com.example.demo.domain.Breed;
import com.example.demo.dto.BreedResponseDto;
import com.example.demo.repository.BreedElasticsearchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BreedService {
	
	private final BreedElasticsearchRepository breedElasticsearchRepository;
	
	// Breed 저장
	public void save(Breed breed) {
		breedElasticsearchRepository.save(BreedDocument.save(breed));
	}
	
	// 검색
	public List<BreedResponseDto> searchName(String breedName){
		
		List<BreedResponseDto> result = breedElasticsearchRepository.findByBreedName(breedName).stream().map(BreedResponseDto::new).collect(Collectors.toList());
		
		return result;
	}
}