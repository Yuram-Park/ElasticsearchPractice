//package com.example.demo;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.demo.document.BreedDocument;
//import com.example.demo.repository.BreedElasticsearchRepository;
//
//@SpringBootTest
//public class BreedESRepositoryTest {
//
//	@Autowired
//	private BreedElasticsearchRepository breedESRepository;
//	
//	@Test
//	public void saveAndGet() {
//		BreedDocument breed = new BreedDocument();
//		
//		breed.setBreedId(1);
//		breed.setBreedName("BASSET HOUND");
//		breedESRepository.save(breed);
//		
//		BreedDocument foundBreed = (BreedDocument) breedESRepository.findByBreedName("BASSET HOUND").get();
//		System.out.println(foundBreed);
//	}
//}
