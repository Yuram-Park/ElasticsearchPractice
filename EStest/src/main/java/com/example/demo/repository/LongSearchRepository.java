package com.example.demo.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.document.LongDocument;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class LongSearchRepository {

	private final ElasticsearchOperations elasticsearchOperations;

	// 기본 검색
	public LongDocument search1(Integer breedId) {
		return elasticsearchOperations.get(breedId.toString(), LongDocument.class);
	}
	
	// NativeQuery
	public List<LongDocument> search2(String breedName) {
		Query query = NativeQuery.builder()
				.withQuery(q -> q.match(m -> m.field("breedNameKo").query(breedName)))
				.build();
		
		SearchHits<LongDocument> searchHits = elasticsearchOperations.search(query, LongDocument.class);
		
		return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
	}
	
	// NativeQuery + fuzzy
	public List<LongDocument> search3(String breedName) {
		//FuzzyQuery fuzzyQuery = QueryBuilders.fuzzy
		Query query = NativeQuery.builder()
				.withQuery(q -> q
						.match(m -> m
								.field("breedName")
								.query(breedName)
								//.fuzziness(breedName) -> 안됨!!!!!!
						)
				)
				.build();
		
		SearchHits<LongDocument> searchHits = elasticsearchOperations.search(query, LongDocument.class);
		
		return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
	}
}
