package com.example.demo.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.document.BreedDocument;
import com.example.demo.util.ChosungParserUtil2;
import com.example.demo.util.ChosungRegexpUtil;
import com.example.demo.util.TermParserUtil;

import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery.Builder;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.RegexpQuery;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BreedCustomRepository {

	private final ElasticsearchOperations elasticsearchOperations;
	private final ChosungParserUtil2 chosungParserUtil;
	private final TermParserUtil termParserUtil;
	private final ChosungRegexpUtil chosungRegexpUtil;
	
	// 초성 검색(Regexp)
	public List<BreedDocument> regSearch(String breedName) {
		
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
	
	
	// 복합쿼리(bool)
	
	public List<BreedDocument> boolSearch(String breedName) {
		
		Map<String, Object> parserResult = termParserUtil.parse(breedName);
		
		// 초성검색용 정규표현식
		String regexp = chosungParserUtil.parse(parserResult.get("chosung").toString());
		
		
		// bool query build
		Builder boolQuery = QueryBuilders.bool()
				// 한글, 영어 검색
				.should(s -> s
						.multiMatch(m -> m
								.fields("breed_name", "breed_name_ko")
								.query(parserResult.get("multiMatch").toString())
								.fuzziness("1")
						)
				)
				// 초성 검색
				.should(s -> s
						.regexp(r -> r
								.field("breed_name_ko")
								.value(regexp)
						)
				);			
		
		if(!parserResult.get("number").toString().isBlank()) {
			// breed_id 검색
			boolQuery.should(s -> s
						.match(m -> m
									.field("breed_id")
									.query(parserResult.get("number").toString())
						)
			);
		}
		
	
		// native query로 build
		NativeQuery query = NativeQuery.builder()
				.withQuery(q -> q
						.bool(boolQuery.build())
				)
				.build();
		
		SearchHits<BreedDocument> searchHits = elasticsearchOperations.search(query, BreedDocument.class);

		return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
	}
	
	
	// 초성검색(Regexp - 초성 외 문자 escape 사용)
	public RegexpQuery regEscapeSearch(String term) {
		
		// 정규표현식
		String regexp = chosungRegexpUtil.parse(term);
		
		RegexpQuery regexpQuery = new RegexpQuery.Builder().field("breed_name_ko").value(regexp).build();

		System.out.println("RegexpQuery :" + regexpQuery);
		return regexpQuery;
	}
	
	
}
