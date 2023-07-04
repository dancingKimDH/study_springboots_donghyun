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

    @GetMapping("/selectInUID")
    public ResponseEntity selectInUID(@RequestBody Map paramMap) {
        Object result = carinforsservice.selectInUID(paramMap);
        return ResponseEntity.ok().body(result);
    }
    // /selectSearch/YEAR/2020
    // /selectSearch/CAR_NAME/소

    @GetMapping("/selectSearch/{search}/{words}")
    public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words) {

        Object result = carinforsservice.selectSearch(search, words);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/selectAll/{CAR_INFOR_ID}")
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) {

        Object result = carinforsservice.selectAll(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

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

    // 2PC
    @PostMapping("/insertDouble")
    public ResponseEntity insertDouble(@RequestBody Map paramMap) {

        Object result = null;
        try {
            result = carinforsservice.insert(paramMap);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ResponseEntity.ok().body(result);

    }

}
