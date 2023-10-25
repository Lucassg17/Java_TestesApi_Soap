package metodos;

import AtribXml.AtributosXml;
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

public class MetodosSoap {
    public static Response criaRequisicaoEmNumberToWords(String valor) throws SOAPException, TransformerException {
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapNumberToWords(valor))
                        .when()
                        .post(Hooks.SETUP.getUrlNumberConversion())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmNumberToDollars(String valor) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapNumberToDollars(valor))
                        .when()
                        .post(Hooks.SETUP.getUrlNumberConversion())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmDivide(String valorA, String valorB) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapDivide(valorA, valorB))
                        .when()
                        .post(Hooks.SETUP.getUrlCaculator())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmMultiply(String valorA, String valorB) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapMultiply(valorA, valorB))
                        .when()
                        .post(Hooks.SETUP.getUrlCaculator())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmSubtract(String valorA, String valorB) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapSubtract(valorA, valorB))
                        .when()
                        .post(Hooks.SETUP.getUrlCaculator())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmListOfContinentsByName() throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapListOfContinents())
                        .when()
                        .post(Hooks.SETUP.getUrlCountryInfoService())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static String criandoCorpoReqSoapNumberToWords(String valor) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURI(), AtributosXml.numberToWords, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(Hooks.SETUP.getNameSpaceURI(), AtributosXml.ubiNum_NumberToWords, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement ubiNum = bodyElement.addChildElement(name);

        ubiNum.addTextNode(valor);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapNumberToDollars(String valor) throws SOAPException, TransformerException{
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURI(), AtributosXml.numberToDollars, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(Hooks.SETUP.getNameSpaceURI(), AtributosXml.dNum_NumberToDollars, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement ubiNum = bodyElement.addChildElement(name);

        ubiNum.addTextNode(valor);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapDivide(String valorA, String valorB) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICalculator(), AtributosXml.divide, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName nameA = new QName(Hooks.SETUP.getNameSpaceURICalculator(), AtributosXml.intA, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement intA = bodyElement.addChildElement(nameA);

        QName nameB = new QName(Hooks.SETUP.getNameSpaceURICalculator(), AtributosXml.intB, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement intB = bodyElement.addChildElement(nameB);

        intA.addTextNode(valorA);
        intB.addTextNode(valorB);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapMultiply(String valorA, String valorB) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICalculator(), AtributosXml.multiply, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName nameA = new QName(Hooks.SETUP.getNameSpaceURICalculator(), AtributosXml.intA, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement intA = bodyElement.addChildElement(nameA);

        QName nameB = new QName(Hooks.SETUP.getNameSpaceURICalculator(), AtributosXml.intB, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement intB = bodyElement.addChildElement(nameB);

        intA.addTextNode(valorA);
        intB.addTextNode(valorB);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapSubtract(String valorA, String valorB) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICalculator(), AtributosXml.subtract, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName nameA = new QName(Hooks.SETUP.getNameSpaceURICalculator(), AtributosXml.intA, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement intA = bodyElement.addChildElement(nameA);

        QName nameB = new QName(Hooks.SETUP.getNameSpaceURICalculator(), AtributosXml.intB, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement intB = bodyElement.addChildElement(nameB);

        intA.addTextNode(valorA);
        intB.addTextNode(valorB);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapListOfContinents() throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml.listOfContinentsByName, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

}
