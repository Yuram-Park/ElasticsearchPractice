package com.example.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import lombok.Getter;
import lombok.Setter;

@Document(indexName="breed")
@Getter
@Setter
@Setting(replicas = 0)
public class BreedDocument {

	@Id
	private Integer breedId;
	
	@Field(type = FieldType.Text)
	private String animalSpecies;
	
	@Field(type = FieldType.Text)
	private String breedName;
	
	@Field(type = FieldType.Text)
	private String breedNameKo;
}
