package com.example.demo.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.document.JasoDocument;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class JasoCustomRepository {

	private final ElasticsearchOperations elasticsearchOperations;
	
	public List<JasoDocument> jasoSearch(String breedName) {
		
		Query query = NativeQuery.builder()
				.withQuery(q -> q
						.multiMatch(m -> m
								.fields("breed_name", "breed_name_ko")
								.query(breedName)
								.fuzziness("1")
						)
				)
				.build();
		
		SearchHits<JasoDocument> searchHits = elasticsearchOperations.search(query, JasoDocument.class);
		
		return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
	}
}
