package com.study.webserverdemo.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class ClientTest {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:9999/cxf_server");
        jaxWsProxyFactoryBean.setServiceClass(HelloWorld.class);
        HelloWorld helloWorld = (HelloWorld) jaxWsProxyFactoryBean.create();
        String result = helloWorld.sayHello("张三", 34);
        System.out.println(result);


    }
}
