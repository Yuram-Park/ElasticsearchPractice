package com.example.demo.dto;

import com.example.demo.document.BreedDocument;
import com.example.demo.document.FuzzyDocument;
import com.example.demo.domain.Breed;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BreedResponseDto {

	private Integer breed_id;
	private String animal_species;
	private String breed_name;
	private String breed_name_ko;
	private String breed_characteristic;
	private String breed_note;
	
	public BreedResponseDto(Breed breed) {
		this.breed_id = breed.getBreed_id();
		this.animal_species = breed.getAnimal_species();
		this.breed_name = breed.getBreed_name();
		this.breed_name_ko = breed.getBreed_name_ko();
		this.breed_characteristic = breed.getBreed_characteristic();
		this.breed_note = breed.getBreed_note();
	}
	
	public BreedResponseDto(BreedDocument breedDocument) {
		this.breed_id = breedDocument.getBreedId();
		this.animal_species = breedDocument.getAnimalSpecies();
		this.breed_name = breedDocument.getBreedName();
	}
	
	public BreedResponseDto(FuzzyDocument fuzzyDocument) {
		this.breed_id = fuzzyDocument.getBreed_id();
		this.breed_name = fuzzyDocument.getBreed_name();
		this.breed_name_ko = fuzzyDocument.getBreed_name_ko();
		this.breed_characteristic = fuzzyDocument.getBreed_characteristic();
		this.breed_note = fuzzyDocument.getBreed_note();
	}
}
