package com.study.webserverdemo.client;

/**
 * wsimport  生成客户端调用
 */
public class ClientTest {
    public static void main(String[] args) {
        HelloWSImplService factory = new HelloWSImplService();
        HelloWS helloWS = factory.getHelloWSImplPort();
        System.out.println(helloWS.sayHello("测试名"));
    }
}
