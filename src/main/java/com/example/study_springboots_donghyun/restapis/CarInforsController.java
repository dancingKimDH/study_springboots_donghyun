package com.example.study_springboots_donghyun.restapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboots_donghyun.service.CarInforsService;

@RestController
public class CarInforsController {
    
    @Autowired
    CarInforsService carinforsservice;

    // /selectDetail/CI002
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) {
        
        Object result = carinforsservice.selectDetail(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

}
