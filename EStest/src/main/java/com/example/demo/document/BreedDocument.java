package com.example.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import com.example.demo.domain.Breed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document(indexName="breed")
@Getter
@Setter
@Setting(replicas = 0)
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class BreedDocument {

	@Id
	private Integer breed_id;
	
	@Field(type = FieldType.Text)
	private String animal_species;
	
	@Field(type = FieldType.Text)
	private String breed_name;
	
	@Field(type = FieldType.Text)
	private String breed_name_ko;
	
	@Field(type = FieldType.Text)
	private String breed_characteristic;
	
	@Field(type = FieldType.Text)
	private String breed_note;
	
	public static BreedDocument save(Breed breed) {
		return BreedDocument.builder()
				.breed_id(breed.getBreed_id())
				.animal_species(breed.getAnimal_species())
				.breed_name(breed.getBreed_name())
				.breed_name_ko(breed.getBreed_name_ko())
				.breed_characteristic(breed.getBreed_characteristic())
				.breed_note(breed.getBreed_note())
				.build();
	}
}
