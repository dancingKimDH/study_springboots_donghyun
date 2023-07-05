package com.example.study_springboots_donghyun.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.study_springboots_donghyun.dao.SharedDao;

@Service
public class carCompanyService {

    @Autowired
    SharedDao sharedDao;

    //update
    public Object update(Map dataMap) {

        String sqlMapId = "carCompanies.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }
    
    
    // insert
    public Object inserting(Map dataMap) {

        String sqlMapId = "carCompanies.inserting";
        Object result = sharedDao.insert(sqlMapId, dataMap);

        return result;
    }
    // search specific
    public Object searching(String name, String words) {

        String sqlMapId = "carCompanies.searching";

        HashMap dataMap = new HashMap<>();
        dataMap.put("name", name);
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    // search all
    public Object searchAll(String COMPANY_ID) {
        String sqlMapId = "carCompanies.searchAll";

        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY_ID", COMPANY_ID);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

}
