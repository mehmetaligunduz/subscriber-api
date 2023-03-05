package com.mag.studycase.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapConfiguration extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/getAllSubscribers");
    }

    @Bean
    public XsdSchema subscriberSchema() {

        return new SimpleXsdSchema(new ClassPathResource("xsd/subscribers.xsd"));

    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema subscriberSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(subscriberSchema);
        definition.setLocationUri("/getAllSubscribers");
        definition.setPortTypeName("SubscriberServicePort");
        definition.setTargetNamespace("http://mag.com/studycase/ws/soap");

        return definition;
    }

}

