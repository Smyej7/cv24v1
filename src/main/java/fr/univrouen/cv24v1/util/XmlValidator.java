package fr.univrouen.cv24v1.util;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.StringReader;

public class XmlValidator {

    private final Validator validator;

    public XmlValidator(String xsdPath) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new StreamSource(xsdPath));
        this.validator = schema.newValidator();
    }

    public void validate(String xmlContent) throws Exception {
        validator.validate(new StreamSource(new StringReader(xmlContent)));
    }
}
