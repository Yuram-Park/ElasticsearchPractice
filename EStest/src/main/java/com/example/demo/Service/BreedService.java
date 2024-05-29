package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.document.BreedDocument;
import com.example.demo.document.LongDocument;
import com.example.demo.domain.Breed;
import com.example.demo.dto.BreedResponseDto;
import com.example.demo.repository.BreedElasticsearchRepository;
import com.example.demo.repository.LongElasticsearchRepository;
import com.example.demo.repository.LongSearchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BreedService {
	
	private final BreedElasticsearchRepository breedElasticsearchRepository;
	private final LongElasticsearchRepository longElasticsearchRepository;
	private final LongSearchRepository longSearchRepository;
	
	// 저장 및 검색
	public void save(Breed breed) {
		breedElasticsearchRepository.save(BreedDocument.save(breed));
	}
	
	public List<BreedResponseDto> searchName(String breedName) {
		
		List<BreedResponseDto> result = breedElasticsearchRepository.findByBreedName(breedName).stream().map(BreedResponseDto::new).collect(Collectors.toList());
		
		return result;
	}
	
	// 저장 및 검색(한국어, 한국어 조사 제거)
	public void save1(Breed breed) {
		longElasticsearchRepository.save(LongDocument.save(breed));
	}
	
	public List<BreedResponseDto> searchName1(String breedName) {
		
		List<BreedResponseDto> result = longElasticsearchRepository.findByBreedNameKo(breedName).stream().map(BreedResponseDto::new).collect(Collectors.toList());
		return result;
	}
	
	// 검색(NativeQuery + Fuzzy)
	public List<LongDocument> searchName2(String breedName) {
		return longSearchRepository.search2(breedName);
	}
	
	
}