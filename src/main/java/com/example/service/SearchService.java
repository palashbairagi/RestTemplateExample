package com.example.service;

import com.example.model.Stock;

import java.util.List;

public interface SearchService {
    public List<Stock> getStock(String name);
}
