package com.study.webserverdemo.test;

import com.study.webserverdemo.test.impl.HelloWorldImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class MainServer {
    public static void main(String[] args) {
        JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
        jaxWsServerFactoryBean.setAddress("http://localhost:9999/cxf_server");
        jaxWsServerFactoryBean.setServiceClass(HelloWorldImpl.class);
        Server server = jaxWsServerFactoryBean.create();
        server.start();
    }
}
