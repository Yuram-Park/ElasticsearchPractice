package com.example.demo.repository;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BreedCustomRepository {

	private final ElasticsearchOperations elasticsearchOperations;
	
	// 초성 검색(유니코드)
//	public List<BreedDocument> uniSearch(String breedName) {
//		
//	}
}
