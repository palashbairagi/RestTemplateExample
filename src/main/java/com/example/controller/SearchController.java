package com.example.controller;

import com.example.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("stockapi/v1/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/{stockname}", method = RequestMethod.GET)
    public ResponseEntity<String> findItem(@PathVariable(value = "stockname") String stockname) {
        try {
            return new ResponseEntity (searchService.getStock(stockname), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
