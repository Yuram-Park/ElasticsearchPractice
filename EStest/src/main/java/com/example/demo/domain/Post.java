package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Post {
	
	private int breed_id;
	private String animal_species;
	private String breed_name;
	private String breed_name_ko;
}
