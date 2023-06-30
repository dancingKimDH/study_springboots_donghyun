package com.example.study_springboots_donghyun.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dao.SharedDao;

@Service
public class HelloWorldService {

    @Autowired
    SharedDao sharedDao;
    public int fakeSelect(String companyId){
        HashMap dataMap = new HashMap<>();
        dataMap.put("companyId", companyId);
        sharedDao.getOne("fake.selectByUID", dataMap);
        return 0;
    }

    public ArrayList fakeSelect(String currentPage,
            String perPage) {
        
                // Service
        ArrayList arrayList = new ArrayList<>();
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);

        resultMap = new HashMap<>();
        resultMap.put("spm_row", 571);
        resultMap.put("CMPNM", "의료유통");
        resultMap.put("RDNMADR", 3);
        arrayList.add(resultMap);

        return arrayList;
    }

}
