package com.mlb.util;


import java.util.HashMap;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.NodeList;

/**
 * Created by Igor Vayner on 9/15/14.
 */

public class XPathUtils {

    private static XPathFactory xpathFactoryInstance;

    private static XPath xpathInstance;

    private static Map<String, XPathExpression> xpathes = new HashMap<String, XPathExpression>();

    private static final Logger LOGGER = Logger.getLogger(XMLUtils.class);

    static {

        xpathFactoryInstance = XPathFactory.newInstance();
        xpathInstance = xpathFactoryInstance.newXPath();

    }

    private static XPathExpression getXpath(String xpath) {
        if (!xpathes.containsKey(xpath)) {
            try {
                LOGGER.info("XPath string: " + xpath);
                xpathes.put(xpath, xpathInstance.compile(xpath));
            } catch (XPathExpressionException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return xpathes.get(xpath);
    }

    public static String getValue(String xmlString, String xpathString) {
        try {

            return (String) getXpath(xpathString).evaluate(XMLUtils.convert(xmlString), XPathConstants.STRING);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    public static NodeList getNodeList(String xmlString, String xpathString) {
        try {
            XPathExpression expr = xpathInstance.compile(xpathString);

            return (NodeList) expr.evaluate(XMLUtils.convert(xmlString), XPathConstants.NODESET);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }
}
