package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.JasoDocument;

@Repository
public interface JasoElasticsearchRepository extends ElasticsearchRepository<JasoDocument, Integer>{

}
