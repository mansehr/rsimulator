package org.rsimulator.core.handler.regexp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Singleton;

/**
 * XmlHandler is a regular expression handler for xml (.xml).
 *
 * @author Magnus Bjuvensjö
 * @see AbstractHandler
 */
@Singleton
public class XmlHandler extends AbstractHandler {
    private static final String EXTENSION = "xml";
    private Logger log = LoggerFactory.getLogger(XmlHandler.class);

    /*
     * (non-Javadoc)
     *
     * @see org.rsimulator.core.handler.regexp.AbstractHandler#format(java.lang.String)
     */
    @Override
    protected String format(String request) {
        String result = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(request.getBytes());
            Document doc = new SAXBuilder().build(bis);
            bis.close();
            Format format = Format.getCompactFormat();
            // To not have the ? in the declaration interpreted as regular expressions.
            format.setOmitDeclaration(true);
            XMLOutputter out = new XMLOutputter(format);
            out.output(doc, bos);
            result = new String(bos.toByteArray());
            bos.close();
        } catch (Exception e) {
            log.error(null, e);
        }
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.rsimulator.core.handler.regexp.AbstractHandler#getExtension()
     */
    @Override
    protected String getExtension() {
        return EXTENSION;
    }
}