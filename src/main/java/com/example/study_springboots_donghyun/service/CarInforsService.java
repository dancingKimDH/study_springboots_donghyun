package com.example.study_springboots_donghyun.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.study_springboots_donghyun.dao.SharedDao;

@Service
public class CarInforsService {

    @Autowired
    SharedDao sharedDao;

    // controller에서 특정 정보를 넣으면 Mapper에 연결, SelectDetail이 호출, Service에 연결,
    // Service에서 Selectdetail을 호출, SharedDao를 호출, SharedDao는 XML을 호출
    // 어디에서 어떤 값을 호출할지가 정확해야 함

    public Object selectDetail(String CAR_INFOR_ID) {
        // Object getOne(String sqlMapId, Object dataMap){
        String sqlMapId = "CarInfors.selectByUID";
            //이때 CarInfors의 Namespace를 가진 CarinforsMapper에서의 selectbyUID는
            // result type이 Map임

        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }
}
