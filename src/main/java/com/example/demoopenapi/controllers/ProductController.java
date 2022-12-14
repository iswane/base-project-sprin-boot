package com.example.demoopenapi.controllers;

import com.example.demoopenapi.services.ProductService;
import com.example.demoopenapi.services.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    private final ProductService service;

    @GetMapping(value = "/all")
    public ResponseEntity<Collection<ProductDTO>> all() {
        log.info("Get all products");
        return new ResponseEntity<>(service.all(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ProductDTO> find(@PathVariable Long id) {
        log.info("Get product by ID [{}]", id);
        return new ResponseEntity<>(service.find(id), HttpStatus.OK);
    }
}
