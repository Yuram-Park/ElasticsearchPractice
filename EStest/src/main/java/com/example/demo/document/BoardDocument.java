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

@Document(indexName="board")
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Setting(replicas = 0, settingPath = "/elasticsearch/settings.json")
@Mapping(mappingPath = "/elasticsearch/mappings.json")
public class BoardDocument {

	@Id
	private Integer breedId;
	
	@Field(type = FieldType.Text)
	private String animalSpecies;
	
	@Field(type = FieldType.Text)
	private String breedName;
	
	@Field(type = FieldType.Text)
	private String breedNameKo;
	
	public static BoardDocument save(Breed breed) {
		return BoardDocument.builder()
				.breedId(breed.getBreedId())
				.breedName(breed.getBreedName())
				.build();
	}
}
