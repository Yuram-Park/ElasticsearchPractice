package com.example.demo.repository;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Repository;

import com.example.demo.util.JamoParserUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BreedCustomRepository {

	private final ElasticsearchOperations elasticsearchOperations;
	private final JamoParserUtil jamoParserUtil;
	
	// 초성 검색(유니코드)
	public List<BreedDocument> uniSearch(String breedName) {
		
		String value = jamoParserUtil.parse(breedName);
		
		Query query = 
	}
}
