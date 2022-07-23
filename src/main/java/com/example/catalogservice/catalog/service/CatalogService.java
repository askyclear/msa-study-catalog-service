package com.example.catalogservice.catalog.service;

import com.example.catalogservice.catalog.entity.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
