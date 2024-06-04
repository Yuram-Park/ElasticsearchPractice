package com.example.demo.repository;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.document.FuzzyDocument;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class FuzzyCustomRepository {

	private final ElasticsearchOperations elasticsearchOperations;

	// 한국어 검색
	public List<FuzzyDocument> findByBreed_name(String breedName) {
		
		Criteria criteria = new Criteria("breed_name").is(breedName).or("breed_name_ko").is(breedName);
		
		Query query = new CriteriaQuery(criteria);
		
		SearchHits<FuzzyDocument> searchHits = elasticsearchOperations.search(query, FuzzyDocument.class);
		return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
	}
	

	// Fuzzy 검색
	public List<FuzzyDocument> fuzzySearch(String breedName) {
		
		// criteria query
		Criteria criteria = new Criteria("breed_name").fuzzy(breedName).or("breed_name_ko").fuzzy(breedName);
		Query cquery = new CriteriaQuery(criteria);
		
		// native query
		Query nquery = NativeQuery.builder()
				.withQuery(q -> q
						.multiMatch(m -> m
								.fields("breed_name", "breed_name_ko")
								.query(breedName)
								.fuzziness("1")
						)
				)
				.build();
				
		SearchHits<FuzzyDocument> searchHits = elasticsearchOperations.search(nquery, FuzzyDocument.class);
		
		return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
	}
}
