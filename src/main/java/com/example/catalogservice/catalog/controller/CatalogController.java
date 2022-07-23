package com.example.catalogservice.catalog.controller;

import com.example.catalogservice.catalog.entity.CatalogEntity;
import com.example.catalogservice.catalog.service.CatalogService;
import com.example.catalogservice.catalog.vo.ResponseCatalog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalogController {
    private final Environment environment;
    private final CatalogService catalogService;

    @Autowired
    public CatalogController(Environment environment, CatalogService catalogService) {
        this.environment = environment;
        this.catalogService = catalogService;
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getUsers() {
        Iterable<CatalogEntity> catalogs = catalogService.getAllCatalogs();
        ModelMapper modelMapper = new ModelMapper();
        List<ResponseCatalog> result = new ArrayList<>();
        catalogs.forEach((catalogEntity) -> result.add(modelMapper.map(catalogEntity, ResponseCatalog.class)));
        return ResponseEntity.ok(result);
    }
}
