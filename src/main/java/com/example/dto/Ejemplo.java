package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Ejemplo {
	
	@JsonProperty("hola")
	private String hola;
	
	@JsonProperty("aaa")
	private String aaa;
	
}
