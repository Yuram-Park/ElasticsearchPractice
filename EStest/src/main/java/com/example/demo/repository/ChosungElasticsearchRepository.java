/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.ChosungDocument;

/**
 * 
 */
@Repository
public interface ChosungElasticsearchRepository extends ElasticsearchRepository<ChosungDocument, Integer>{

}
