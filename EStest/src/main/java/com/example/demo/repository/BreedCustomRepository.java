package com.example.demo.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.document.BreedDocument;
import com.example.demo.util.ChosungParserUtil;
import com.example.demo.util.ChosungParserUtil2;

import co.elastic.clients.elasticsearch._types.query_dsl.RegexpQuery;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BreedCustomRepository {

	private final ElasticsearchOperations elasticsearchOperations;
	private final ChosungParserUtil2 chosungParserUtil;
	
	// 초성 검색(유니코드)
	public List<BreedDocument> uniSearch(String breedName) {
		
		// 정규표현식
		String regexp = chosungParserUtil.parse(breedName);
		
		Query nquery = NativeQuery.builder()
				.withQuery(q -> q
						.regexp(r -> r
								.field("breed_name_ko")
								.value(regexp)
						)
				)
				.build();

		SearchHits<BreedDocument> searchHits = elasticsearchOperations.search(nquery, BreedDocument.class);

		return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
	}
}
