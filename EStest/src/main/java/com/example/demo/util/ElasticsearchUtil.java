package com.example.demo.util;

import java.util.function.Supplier;

import co.elastic.clients.elasticsearch._types.query_dsl.FuzzyQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.FuzzyQuery.Builder;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;

public class ElasticsearchUtil {

	public static Supplier<Query> createSupplierQuery(String approximateName) {
		Supplier<Query> sup = () -> Query.of(q -> q.fuzzy(createFuzzyQuery(approximateName)));
		return sup;
	}
	
	public static FuzzyQuery createFuzzyQuery(String approximateName) {
		Builder fuzzyQuery = new FuzzyQuery.Builder();
		return fuzzyQuery.field("breedName").value(approximateName).build();
	}
}
