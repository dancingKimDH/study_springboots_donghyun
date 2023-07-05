package com.example.study_springboots_donghyun.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboots_donghyun.service.carCompanyService;

@RestController
public class carCompanyController {

    @Autowired
    carCompanyService carcompanyservice;

    // update
    @PutMapping("/updater")
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = carcompanyservice.update(paramMap);
        return ResponseEntity.ok().body(result);

    }

    // insert
    @PostMapping("/inserting")
    public ResponseEntity inserting(@RequestBody Map paramMap) {

        Object result = carcompanyservice.inserting(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // search specific item
    @GetMapping("/searching/{name}/{words}")
    public ResponseEntity searching(@PathVariable String name, @PathVariable String words) {

        Object result = carcompanyservice.searching(name, words);
        return ResponseEntity.ok().body(result);
    }

    // search all
    @GetMapping("/searchAll/{COMPANY_ID}")
    public ResponseEntity searchAll(@PathVariable String COMPANY_ID) {
        Object result = carcompanyservice.searchAll(COMPANY_ID);
        return ResponseEntity.ok().body(result);
    }

}
