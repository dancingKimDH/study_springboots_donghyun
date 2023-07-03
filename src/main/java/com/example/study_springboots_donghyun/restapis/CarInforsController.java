package com.example.study_springboots_donghyun.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // header을 이용해 보이지 않게 data 이동
    // 이후 body로 보여줌

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Map paramMap) {
        Object result = carinforsservice.insert(paramMap);
        return ResponseEntity.ok().body(result);

    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = carinforsservice.update(paramMap);
        return ResponseEntity.ok().body(result);

    }

    // delete
    @DeleteMapping("/delete/{CAR_INFOR_ID}")
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID) {

        Object result = carinforsservice.delete(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

}
