package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.NoriDocument;

@Repository
public interface NoriElasticsearchRepository extends ElasticsearchRepository<NoriDocument, Integer>{

}
