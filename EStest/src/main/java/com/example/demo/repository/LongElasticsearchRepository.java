package com.example.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.BreedDocument;
import com.example.demo.document.LongDocument;

@Repository
public interface LongElasticsearchRepository extends ElasticsearchRepository<LongDocument, Integer>{

	List<LongDocument> findByBreedNameKo(String breedNameKo);
}
