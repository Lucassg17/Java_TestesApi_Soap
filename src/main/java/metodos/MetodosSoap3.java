package metodos;

import AtribXml.AtributosXml2;
import Utils.Hooks;
import io.restassured.response.Response;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.StringWriter;

import static io.restassured.RestAssured.given;

public class MetodosSoap3 {
    public static Response criarRequisicaoEmListOfCountriesByName() throws SOAPException, TransformerException {
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapLanguagesByName())
                        .when()
                        .post(Hooks.SETUP.getUrlCountryInfoService())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmIsbn13(String valorA) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapIsbn13(valorA))
                        .when()
                        .post(Hooks.SETUP.getUrlIsbnService())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmIsbn10(String valorA) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapIsbn10(valorA))
                        .when()
                        .post(Hooks.SETUP.getUrlIsbnService())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmCelsiusToFahrenheit(String valorA) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapCelsiusToFahrenheit(valorA))
                        .when()
                        .post(Hooks.SETUP.getUrlTemp())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmFahrenheitToCelsius(String valorA) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapFahrenheitToCelsius(valorA))
                        .when()
                        .post(Hooks.SETUP.getUrlTemp())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static String criandoCorpoReqSoapLanguagesByName() throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.listOfLanguagesByName, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapIsbn13(String valorA) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURIIsbn(), AtributosXml2.isValidISBN13, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(Hooks.SETUP.getNameSpaceURIIsbn(), AtributosXml2.sISBN, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement sIsbn = bodyElement.addChildElement(name);

        sIsbn.addTextNode(valorA);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapIsbn10(String valorA) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURIIsbn(), AtributosXml2.isValidISBN10, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(Hooks.SETUP.getNameSpaceURIIsbn(), AtributosXml2.sISBN, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement sIsbn = bodyElement.addChildElement(name);

        sIsbn.addTextNode(valorA);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapCelsiusToFahrenheit(String valorA) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURITemp(), AtributosXml2.celsiusToFahrenheit, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(Hooks.SETUP.getNameSpaceURITemp(), AtributosXml2.celsius, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement celsius = bodyElement.addChildElement(name);

        celsius.addTextNode(valorA);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapFahrenheitToCelsius(String valorA) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURITemp(), AtributosXml2.fahrenheitToCelsius, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(Hooks.SETUP.getNameSpaceURITemp(), AtributosXml2.fahrenheit, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement fahrenheit = bodyElement.addChildElement(name);

        fahrenheit.addTextNode(valorA);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }
}
