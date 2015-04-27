
package com.ws.tutorial.ws_example;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ws.tutorial.ws_example package. 
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

    private final static QName _GetDiff_QNAME = new QName("http://ws_example.tutorial.ws.com/", "getDiff");
    private final static QName _GetDiffResponse_QNAME = new QName("http://ws_example.tutorial.ws.com/", "getDiffResponse");
    private final static QName _GetSum_QNAME = new QName("http://ws_example.tutorial.ws.com/", "getSum");
    private final static QName _GetSumResponse_QNAME = new QName("http://ws_example.tutorial.ws.com/", "getSumResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ws.tutorial.ws_example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDiff }
     * 
     */
    public GetDiff createGetDiff() {
        return new GetDiff();
    }

    /**
     * Create an instance of {@link GetDiffResponse }
     * 
     */
    public GetDiffResponse createGetDiffResponse() {
        return new GetDiffResponse();
    }

    /**
     * Create an instance of {@link GetSum }
     * 
     */
    public GetSum createGetSum() {
        return new GetSum();
    }

    /**
     * Create an instance of {@link GetSumResponse }
     * 
     */
    public GetSumResponse createGetSumResponse() {
        return new GetSumResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDiff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_example.tutorial.ws.com/", name = "getDiff")
    public JAXBElement<GetDiff> createGetDiff(GetDiff value) {
        return new JAXBElement<GetDiff>(_GetDiff_QNAME, GetDiff.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDiffResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_example.tutorial.ws.com/", name = "getDiffResponse")
    public JAXBElement<GetDiffResponse> createGetDiffResponse(GetDiffResponse value) {
        return new JAXBElement<GetDiffResponse>(_GetDiffResponse_QNAME, GetDiffResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_example.tutorial.ws.com/", name = "getSum")
    public JAXBElement<GetSum> createGetSum(GetSum value) {
        return new JAXBElement<GetSum>(_GetSum_QNAME, GetSum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_example.tutorial.ws.com/", name = "getSumResponse")
    public JAXBElement<GetSumResponse> createGetSumResponse(GetSumResponse value) {
        return new JAXBElement<GetSumResponse>(_GetSumResponse_QNAME, GetSumResponse.class, null, value);
    }

}
