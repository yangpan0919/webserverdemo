package com.study.webserverdemo.ws;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.Schema;
import org.apache.log4j.Logger;

import javax.xml.namespace.QName;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AvaryAxisUtil {

    private static final Logger logger = Logger.getLogger(AvaryAxisUtil.class);

    public static void main(String[] args) {
//        String sayHello = webServicesToCRM("sayHello", new Object[]{"小胖子"});
//        System.out.println(sayHello);
        Schema schema = new Schema();
//        MessageElement[] FOCElement = schema.get_any();//取得xml信息
//        List FOCElementHead = FOCElement[0].getChildren();//消息头,DataSet对象
//        List FOCElementBody = FOCElement[1].getChildren();//消息体信息,DataSet对象
//        if (FOCElementBody.size() <= 0){
//            //无返回记录，则无输出
//            return ;
//        }
//        String nn = FOCElementBody.get(0).toString();//消息体的字符串形式

        String xmlStr = "<NewDataSet>\n" +
                "    <Table>\n" +
                "        <TID>Xtest01</TID>\n" +
                "        <BAR>昨天</BAR>\n" +
                "        <TIME>Xtest01</TIME>\n" +
                "    </Table>\n" +
                "    <Table>\n" +
                "        <TID>Xtest02</TID>\n" +
                "        <BAR>今天</BAR>\n" +
                "        <TIME>Xtest01</TIME>\n" +
                "    </Table>\n" +
                "</NewDataSet>";
        String str = "<NewDataSet/>";
        List<Map<String,String>> list = new ArrayList<>();
        createList(list,xmlStr);
        System.out.println(list);

    }
    public static void createList(List list,String text){
        if(text.contains("<Table>")){
            int i = text.indexOf("<Table>");
            int j = text.indexOf("</Table>");
            String sub1 = text.substring(i + 7, j);
            String sub2 = text.substring(j + 8);

            Map<String,String > map  = new HashMap<>();
            createMap(map,sub1);
            list.add(map);
            createList(list,sub2);
        }
    }
    public static void createMap(Map<String,String> map,String text){
        if(text.contains("<")){
            int i = text.indexOf("<");
            int j = text.indexOf(">");
            String key =text.substring(i+1,j);
            String sub1 = text.substring(j + 1);
            i = sub1.indexOf("<");
            j = text.indexOf(">");
            String value = sub1.substring(0, i);
            map.put(key,value);
            createMap(map,sub1.substring(j+1));
        }
    }

    public static String webServicesToCRM(String method, Object[] parms) {

        String endPoint = "http://localhost:9999/test/hello";
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new URL(endPoint));
//            call.setOperationName("{http://ws.webserverdemo.study.com/}"+method);
//            call.setOperationName(new QName("{http://ws.webserverdemo.study.com/}"+method));
//            call.setUseSOAPAction(true);
//            call.setSOAPActionURI("http://ws.webserverdemo.study.com/" + method); // action uri
//            call.setOperationName(method);// 设置要调用哪个方法

            call.setOperationName(method);
            String jsonResult = String.valueOf(call.invoke(parms));
            logger.info("调用CRM的接口中方法--》" + method + "：的结果：" + jsonResult);
            return jsonResult;
        } catch (Exception e) {
            logger.error("调用CRM的接口中方法--》" + method + "：方法异常：", e);
            return "Error";
        }
    }
}
