package com.example.study_springboots_donghyun.restapis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//extends - Bean에서 확인
@Controller
public class HelloWorldController {

    // doGet method, urlPatterns - Endpoint에서 확인
    @GetMapping("/helloWorld")
    public int helloWorld() {
        return 0;
    }

    // /helloWorldGetRequest?Name=yojulab&ID=U-01 (기존 형식)
    // /helloWorldGetRequest/yojulab/U-01 (새로운 형식) 보안에도 유리
    // url의 위치값에 의해서 yojulab을 Name으로 인식
    @GetMapping("/helloWorldGetRequest/{name}/{id}")

    //PathVariable로 Capping
    public int helloWorldGetRequest(@PathVariable String name, String id) {
        return 0;

    }

    @GetMapping("/helloWorldGetResponse")
    public int helloWorldGetResponse() {
        return 0;

    }

}
