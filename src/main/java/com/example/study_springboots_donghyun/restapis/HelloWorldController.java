package com.example.study_springboots_donghyun.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.study_springboots_donghyun.service.HelloWorldService;

//extends - Bean에서 확인
@Controller
public class HelloWorldController {

    @Autowired
    HelloWorldService helloWorldService;

    // doGet method, urlPatterns - Endpoint에서 확인
    @GetMapping("/helloWorld")
    public int helloWorld() {
        return 0;
    }

    // /helloWorldGetRequest?Name=yojulab&ID=U-01 (기존 형식)
    // /helloWorldGetRequest/yojulab/U-01 (새로운 형식) 보안에도 유리
    // url의 위치값에 의해서 yojulab을 Name으로 인식
    @GetMapping("/helloWorldGetRequest/{name}/{id}")

    // PathVariable로 Capping
    public int helloWorldGetRequest(@PathVariable String name, @PathVariable String id) {
        return 0;

    }

    // ?serviceKey=ab5XSHW0eOiAmWhlVe1Qtqzmut13uzseiVqXmu35AT0zQwCwjBhHELGx3F1%2BZGkhBwcyAKzKYzLcLtjKt%2B6xLA%3D%3D
    // &currentPage=1
    // &perPage=10
    // &SN=1

    // generic은 들어갈 수 있는 데이터타입을 규정해 놓은 것
    // object는 모든 클래스가 상속 받는 최상위. 따라서 어떤 data type이든 가능
    // Spring은 자체적으로 object로 선언된 변수의 data type을 식별

    @GetMapping("/helloWorldGetResponse/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldGetResponse(@PathVariable String currentPage, @PathVariable String perPage,
            @PathVariable String SN) {

        // "spm_row": 471,
        // "SN": 1,
        // "CMPNM": "로이유통",
        // "RDNMADR": null,으로 HashMap 만들어서 부르기
        // helloWorldResponse/1/10/1으로 브라우저에 입력해 확인해보기
        // 이때 Endpoint Mappings에 정상적으로 있는지 확인할 것!
        // 이때 숫자는 Double Quotation이 없게 입력해 받는 사람이 편리하게 받을 수 있도록 할 것

        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);

        // ResponseEntity에서는 Header와 Body를 설정해서 넣어야 함
        // ok를 넣으면 Server message 2--와 마찬가지로 정상적으로 작동하도록 함
        return ResponseEntity.ok().body(resultMap);
    }

    @GetMapping("/helloWorldGetResponseList/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldGetResponseList(@PathVariable String currentPage,
            @PathVariable String perPage,
            @PathVariable String SN) {

        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3

        ArrayList arrayList = new ArrayList<>();
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);

        resultMap = new HashMap<>();
        resultMap.put("spm_row", 571);
        resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");
        resultMap.put("RDNMADR", 3);
        arrayList.add(resultMap);

        return ResponseEntity.ok().body(arrayList);
    }

    // Service에서 ArrayList Call하기
    @GetMapping("/helloWorldResponseWithService/{currentPage}/{perPage}")
    public ResponseEntity<Object> helloWorldResponseWithService(@PathVariable String currentPage,
            @PathVariable String perPage) {

        // 기존 Instantiate 방법. Spring에서는 IOC가 자동적으로 지원.
        // HelloWorldService helloWorldService = new HelloWorldService();
        // 맨 상위에 Class와 Method 사이에 HelloWorldService helloWorldService 작성
        // 그리고 @Autowired라는 Annotation을 부여해서 언제든 사용할 수 있도록 함
        // 이런 내용들은 Spring이 Memory로 올려 보냄

        ArrayList arrayList = helloWorldService.fakeSelect(currentPage, perPage);

        return ResponseEntity.ok().body(arrayList);
    }

}
