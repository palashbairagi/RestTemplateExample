package com.example.service;

import com.example.model.SearchJsonResponse;
import com.example.model.Stock;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public List<Stock> getStock(String name) {

        String URL = "https://api.worldtradingdata.com/api/v1/stock?symbol="+name+"&api_token=cYDw6OCIFS7okSkLnHj4oR6kP5H3pbQJNBQ9RIFUKZ6MOZYQxAHHhaBWsTfx";

        RestTemplate restTemplate = new RestTemplate();
        SearchJsonResponse searchJsonResponse = restTemplate.getForObject(URL, SearchJsonResponse.class);
        return searchJsonResponse.getData();
    }
}
