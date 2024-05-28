package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.BoardDocument;

@Repository
public interface BoardElasticsearchRepository extends ElasticsearchRepository<BoardDocument, Integer>{

}
