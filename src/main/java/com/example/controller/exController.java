package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.Ejemplo;
import com.example.service.ExampleService;

import javax.validation.Valid;

@RestController
@RequestMapping("/example")
public class exController {
	
	@Autowired
	private ExampleService ex;
	
	@RequestMapping(value = "/eqParam ",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> eqParam(@Valid @RequestBody Ejemplo body) {
        ResponseEntity<Object> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<Object>(body, HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            System.out.println(ex);
        }
        return responseEntity;
    }
	
	@RequestMapping(value = "/passMsj2Cpp",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> passMsj2Cpp(@Valid @RequestBody Ejemplo body) {
        ResponseEntity<Object> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<Object>(ex.ex(body), HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            System.out.println(ex);
        }
        return responseEntity;
    }
	
}
