package com.study.webserverdemo.test;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHello(String name, int age);
}
