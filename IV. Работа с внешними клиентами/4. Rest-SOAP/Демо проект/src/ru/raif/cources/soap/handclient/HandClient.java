package ru.raif.cources.soap.handclient;

import ru.raiffeisen.cources.soap.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class HandClient {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/hello?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.cources.raiffeisen.ru/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getHelloWorldAsString("hi"));

    }
}
