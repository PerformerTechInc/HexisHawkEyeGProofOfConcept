package com.mlb.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Created by Igor Vayner on 9/15/14.
 */

public class XMLUtils {

    private static final Logger LOGGER = Logger.getLogger(XMLUtils.class);

    private static final DocumentBuilderFactory documentFactoryInstance;

    private static final DocumentBuilder documentBuilderInstance;

    static {
        documentFactoryInstance = DocumentBuilderFactory.newInstance();
        try {
            documentBuilderInstance = documentFactoryInstance.newDocumentBuilder();
            LOGGER.info("Document Builder Factory was created");
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static Document convert(String xmlString) {
        try {

            return documentBuilderInstance.parse(new InputSource(new StringReader(xmlString)));

        } catch (SAXException e) {
            throw new RuntimeException(e.getMessage(), e);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}