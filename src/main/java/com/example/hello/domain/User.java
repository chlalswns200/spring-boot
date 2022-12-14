package com.example.hello.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class User {

    private String id;
    private String name;
    private String password;
}
