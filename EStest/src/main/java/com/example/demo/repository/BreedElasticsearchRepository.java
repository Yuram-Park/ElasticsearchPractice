package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.BreedDocument;

@Repository
public interface BreedElasticsearchRepository extends ElasticsearchRepository<BreedDocument, Integer>{

}
