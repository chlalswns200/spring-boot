package com.example.hello.controller;


import com.example.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "minjun";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/request1")
    public String getVariable2(@RequestParam String name,@RequestParam String email,@RequestParam String organization) {
        return String.format("%s %s %s",name,email,organization);
    }

    @GetMapping(value = "/request2")
    public String getVariable3(@RequestParam Map<String,String> emp) {
        emp.entrySet().forEach((map) ->{
            System.out.printf("key:%s value:%s\n",map.getKey(),map.getValue());
        });
        return "완료";
    }

    @GetMapping(value = "/request3")
    public String getVariable3(MemberDto memberDto) {
        return memberDto.toString();
    }


}
