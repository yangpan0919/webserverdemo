package com.study.webserverdemo.ws;


import javax.xml.ws.Endpoint;

public class MainTestServer {
    public static void main(String[] args) {
        String address = "http://localhost:9999/test/hello";
        Endpoint.publish(address,new HelloWSImpl());
        System.out.println("发布成功");
    }
}
