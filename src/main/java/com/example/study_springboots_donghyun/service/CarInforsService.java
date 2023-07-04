package com.example.study_springboots_donghyun.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.study_springboots_donghyun.dao.SharedDao;

@Service
@Transactional
public class CarInforsService {

    @Autowired
    SharedDao sharedDao;


    @GetMapping("/selectInUID")
    public ResponseEntity selectInUID(Map dataMap) {
        String sqlMapId = "CarInfors.selectInUID";
        Object result = null;
        try {
            
            
            result = sharedDao.getList(sqlMapId, dataMap);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ResponseEntity.ok().body(result);
    }

    public Object selectSearch(String search, String words) {

        String sqlMapId = "CarInfors.selectSearch";

        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    // Select all

    public Object selectAll(String CAR_INFOR_ID) {
        // Object getOne(String sqlMapId, Object dataMap){
        String sqlMapId = "CarInfors.selectAll";
        // 이때 CarInfors의 Namespace를 가진 CarinforsMapper에서의 selectbyUID는
        // result type이 Map임

        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    // controller에서 특정 정보를 넣으면 Mapper에 연결, SelectDetail이 호출, Service에 연결,
    // Service에서 Selectdetail을 호출, SharedDao를 호출, SharedDao는 XML을 호출
    // 어디에서 어떤 값을 호출할지가 정확해야 함

    public Object selectDetail(String CAR_INFOR_ID) {
        // Object getOne(String sqlMapId, Object dataMap){
        String sqlMapId = "CarInfors.selectByUID";
        // 이때 CarInfors의 Namespace를 가진 CarinforsMapper에서의 selectbyUID는
        // result type이 Map임

        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object insert(Map dataMap) {

        String sqlMapId = "CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;

    }

    public Object update(Map dataMap) {

        String sqlMapId = "CarInfors.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object delete(String CAR_INFOR_ID) {

        String sqlMapId = "CarInfors.delete";
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);
        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }

    // 2PC
    public Object insertDouble(Map dataMap) {

        String sqlMapId = "CarInfors.insert";
        // success
        Object result = sharedDao.insert(sqlMapId, dataMap);
        // error
        result = sharedDao.insert(sqlMapId, dataMap);
        return result;

    }

}
