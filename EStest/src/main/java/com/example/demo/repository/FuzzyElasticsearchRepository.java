package com.example.demo.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.FuzzyDocument;

@Repository
public interface FuzzyElasticsearchRepository extends ElasticsearchRepository<FuzzyDocument, Integer>{
	
}
