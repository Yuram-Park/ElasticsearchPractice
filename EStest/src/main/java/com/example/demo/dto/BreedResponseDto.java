package com.example.demo.dto;

import com.example.demo.document.BreedDocument;
import com.example.demo.document.LongDocument;
import com.example.demo.domain.Breed;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BreedResponseDto {

	private Integer breedId;
	private String animalSpecies;
	private String breedName;
	private String breedNameKo;
	
	public BreedResponseDto(Breed breed) {
		this.breedId = breed.getBreedId();
		this.breedName = breed.getBreedName();
	}
	
	public BreedResponseDto(BreedDocument breedDocument) {
		this.breedId = breedDocument.getBreedId();
		this.breedName = breedDocument.getBreedName();
	}
	
	public BreedResponseDto(LongDocument longDocument) {
		this.breedId = longDocument.getBreedId();
		this.breedName = longDocument.getBreedName();
		this.breedNameKo = longDocument.getBreedNameKo();
	}
}
