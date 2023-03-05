
package com.mag.studycase.model.soap;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mag.studycase.model.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SubscribersRequest_QNAME = new QName("http://mag.com/studycase/model/soap", "SubscribersRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mag.studycase.model.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubscriberListResponse }
     * 
     */
    public SubscriberListResponse createSubscriberListResponse() {
        return new SubscriberListResponse();
    }

    /**
     * Create an instance of {@link Subscriber }
     * 
     */
    public Subscriber createSubscriber() {
        return new Subscriber();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://mag.com/studycase/model/soap", name = "SubscribersRequest")
    public JAXBElement<Object> createSubscribersRequest(Object value) {
        return new JAXBElement<Object>(_SubscribersRequest_QNAME, Object.class, null, value);
    }

}
