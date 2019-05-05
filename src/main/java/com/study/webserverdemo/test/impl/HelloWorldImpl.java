package com.study.webserverdemo.test.impl;

import com.study.webserverdemo.test.HelloWorld;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHello(String name, int age) {
        return "cxf_server name = "+name;
    }
}
