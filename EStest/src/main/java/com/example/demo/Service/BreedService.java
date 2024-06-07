package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.document.BreedDocument;
import com.example.demo.document.FuzzyDocument;
import com.example.demo.document.JasoDocument;
import com.example.demo.domain.Breed;
import com.example.demo.dto.BreedResponseDto;
import com.example.demo.repository.BreedCustomRepository;
import com.example.demo.repository.BreedElasticsearchRepository;
import com.example.demo.repository.FuzzyCustomRepository;
import com.example.demo.repository.FuzzyElasticsearchRepository;
import com.example.demo.repository.JasoCustomRepository;
import com.example.demo.repository.JasoElasticsearchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BreedService {
	
	private final BreedElasticsearchRepository breedElasticsearchRepository;
	private final FuzzyElasticsearchRepository fuzzyElasticsearchRepository;
	private final FuzzyCustomRepository fuzzyCustomRepository;
	private final JasoElasticsearchRepository jasoElasticsearchRepository;
	private final JasoCustomRepository jasoCustomRepository;
	private final BreedCustomRepository breedCustomRepository;
	
	// 기본 저장 및 검색
	public void save(Breed breed) {
		breedElasticsearchRepository.save(BreedDocument.save(breed));
	}
	
	public List<BreedResponseDto> searchName(String breedName) {
		
		List<BreedResponseDto> result = null;
		
		return result;
	}
	
	// 한국어, 한국어 조사 제거 저장 및 검색
	public void koSave(Breed breed) {
		fuzzyElasticsearchRepository.save(FuzzyDocument.save(breed));
	}
	
	public List<BreedResponseDto> koSearch(String breedName) {
		
		List<BreedResponseDto> result = fuzzyCustomRepository.findByBreed_name(breedName).stream().map(BreedResponseDto::new).collect(Collectors.toList());
		return result;
	}
	
	// Fuzzy 검색
	public List<FuzzyDocument> fuzzySearch(String breedName) {
		return fuzzyCustomRepository.fuzzySearch(breedName);
	}
	
	
	// 초성 검색(플러그인 도입)
	public void jasoSave(Breed breed) {
		jasoElasticsearchRepository.save(JasoDocument.save(breed));
	}
	
	public List<JasoDocument> jasoSearch(String breedName) {
		return jasoCustomRepository.jasoSearch(breedName);
	}
	
	
	// 초성 검색(유니코드)
	public List<BreedDocument> uniSearch(String breedName) {
		return breedCustomRepository.uniSearch(breedName);
	}
}