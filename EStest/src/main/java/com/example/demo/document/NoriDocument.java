package com.example.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Document(indexName="nori")
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Setting(replicas = 0, settingPath = "/elasticsearch/settings.json")
@Mapping(mappingPath = "/elasticsearch/mappings.json")
public class NoriDocument {

	@Id
	private Integer student_id;
	
	@Field(type = FieldType.Text)
	private String student_name;
	
	@Field(type = FieldType.Text)
	private String student_class;
}
