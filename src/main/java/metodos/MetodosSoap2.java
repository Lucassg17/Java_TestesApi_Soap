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

public class MetodosSoap2 {
    public static Response criarRequisicaoEmListOfCountriesByName() throws SOAPException, TransformerException {
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapListOfCountries())
                        .when()
                        .post(Hooks.SETUP.getUrlCountryInfoService())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmCapitalCityForACountry(String valorA) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapCapitalCityForACountry(valorA))
                        .when()
                        .post(Hooks.SETUP.getUrlCountryInfoService())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmCurrencyCountry(String valorA) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapCurrencyCountry(valorA))
                        .when()
                        .post(Hooks.SETUP.getUrlCountryInfoService())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmFlagCountry(String valorA) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapFlagCountry(valorA))
                        .when()
                        .post(Hooks.SETUP.getUrlCountryInfoService())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmInterPhoneCountry(String valorA) throws SOAPException, TransformerException{
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapPhoneCodeCountry(valorA))
                        .when()
                        .post(Hooks.SETUP.getUrlCountryInfoService())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static Response criarRequisicaoEmCurrenciesByName() throws SOAPException, TransformerException {
        Response pegaResponse =
                given()
                        .contentType("text/xml; charset=utf-8")
                        .body(criandoCorpoReqSoapCurrenciesByName())
                        .when()
                        .post(Hooks.SETUP.getUrlCountryInfoService())
                        .then()
                        .extract().response();

        return pegaResponse;
    }

    public static String criandoCorpoReqSoapPhoneCodeCountry(String valorA) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.countryIntPhoneCode, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.sCountryISOCode, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement sCountryISOCode = bodyElement.addChildElement(name);

        sCountryISOCode.addTextNode(valorA);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapFlagCountry(String valorA) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.countryFlag, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.sCountryISOCode, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement sCountryISOCode = bodyElement.addChildElement(name);

        sCountryISOCode.addTextNode(valorA);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapCurrencyCountry(String valorA) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.countryCurrency, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.sCountryISOCode, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement sCountryISOCode = bodyElement.addChildElement(name);

        sCountryISOCode.addTextNode(valorA);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapCapitalCityForACountry(String valorA) throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.capitalCity, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.sCountryISOCode, Hooks.SETUP.getNameSpacePrefix());
        SOAPElement sCountryISOCode = bodyElement.addChildElement(name);

        sCountryISOCode.addTextNode(valorA);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapListOfCountries() throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.listOfCountryNamesByName, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }

    public static String criandoCorpoReqSoapCurrenciesByName() throws SOAPException, TransformerException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPBody body = soapMessage.getSOAPBody();

        QName bodyName = new QName(Hooks.SETUP.getNameSpaceURICountryInfo(), AtributosXml2.listOfCurrenciesByName, Hooks.SETUP.getNameSpacePrefix());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        // Convertendo a message SOAP em string
        StringWriter sw = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(
                new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));

        return sw.toString();
    }
}
