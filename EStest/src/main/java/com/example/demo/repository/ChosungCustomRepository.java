/**
 * 
 */
package com.example.demo.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.document.ChosungDocument;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
@Repository
public class ChosungCustomRepository {

	private final ElasticsearchOperations elasticsearchOperations;
	
	public List<ChosungDocument> chosungSearch(String breedName) {
		
		Query query = NativeQuery.builder()
				.withQuery(q -> q
						.multiMatch(m -> m
								.fields("breed_name", "breed_name_ko")
								.query(breedName)
								.fuzziness("1")
						)
				)
				.build();
		
		SearchHits<ChosungDocument> searchHits = elasticsearchOperations.search(query, ChosungDocument.class);
		
		return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
	}
}
