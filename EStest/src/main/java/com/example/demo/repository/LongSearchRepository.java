package com.example.demo.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.document.LongDocument;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class LongSearchRepository {

	private final ElasticsearchOperations elasticsearchOperations;

	// 기본 검색
	public LongDocument search1(Integer breedId) {
		return elasticsearchOperations.get(breedId.toString(), LongDocument.class);
	}
	

	// NativeQuery + fuzzy
	public List<LongDocument> search2(String breedName) {
		
		Query query = NativeQuery.builder()
				.withQuery(q -> q
						.multiMatch(m -> m
								.fields("breedName", "breedNameKo")
								.query(breedName)
								.fuzziness("2")
						)
				)
				.build();

		SearchHits<LongDocument> searchHits = elasticsearchOperations.search(query, LongDocument.class);
		
		return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
	}
	
	
}
