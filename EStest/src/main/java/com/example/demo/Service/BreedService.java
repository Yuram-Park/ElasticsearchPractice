package com.example.demo.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import com.example.demo.document.BreedDocument;
import com.example.demo.repository.BreedElasticsearchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BreedService {
	
	private final BreedElasticsearchRepository breedElasticsearchRepository;
	
	public Map<String, Object> searchName(String breedName){
		
		// elasticsearch 검색
		SearchHits<BreedDocument> searchHits = breedElasticsearchRepository.findByBreedName(breedName);
		
		Map<String, Object> result = new HashMap<>();
		
		// 결과 개수
		result.put("count", searchHits.getTotalHits());
		
		// 결과 컨텐츠
		// Document 를 Dto로 바꿔줘야함
		//List<AlcoholDTO> alcoholDTOList = new ArrayList<>();
        //for(SearchHit<AlcoholDocument> hit : searchHits) {
            // from AlcoholDocument to AlcoholDTO 변환
        //}
        //result.put("data", alcoholDTOList);
		System.out.println(searchHits);
		
		return result;
	}
}