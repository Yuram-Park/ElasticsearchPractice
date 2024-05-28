package com.example.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

import com.example.demo.domain.Breed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document(indexName="long")
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Setting(replicas = 0, settingPath = "/elasticsearch/settings.json")
@Mapping(mappingPath = "/elasticsearch/mappings.json")
public class LongDocument {
	@Id
	private Integer breedId;
	
	@Field(type = FieldType.Text)
	private String animalSpecies;
	
	@Field(type = FieldType.Text)
	private String breedName;
	
	@Field(type = FieldType.Text)
	private String breedNameKo;
	
	public static LongDocument save(Breed breed) {
		return LongDocument.builder()
				.breedId(breed.getBreedId())
				.breedName(breed.getBreedName())
				.breedNameKo(breed.getBreedNameKo())
				.build();
	}
}
