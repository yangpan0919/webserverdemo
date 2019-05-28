package com.study.webserverdemo.ws;


import javax.jws.WebService;

@WebService
public class HelloWSImpl implements HelloWS {

    @Override
    public String sayHello(String name) {
        System.out.println("webservice 调用成功");
        return "返回名字：" + name;
    }
}
