package fr.univrouen.cv24v1.services;

import fr.univrouen.cv24v1.models.Cv;
import fr.univrouen.cv24v1.repositories.CvRepository;
import fr.univrouen.cv24v1.util.XmlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;
import java.util.Optional;

@Service
public class CvService {

    @Autowired
    private CvRepository cvRepository;

    private final XmlValidator xmlValidator;

    public CvService() throws Exception {
        this.xmlValidator = new XmlValidator("src/main/resources/cv24.tp1.xsd");
    }

    public List<Cv> getAllCvs() {
        return cvRepository.findAll();
    }

    public Optional<Cv> getCvById(Long id) {
        return cvRepository.findById(id);
    }

    public boolean addCv(String xmlContent) throws Exception {
        try {
            xmlValidator.validate(xmlContent);
        } catch (Exception e) {
            throw new Exception("Invalid XML content: " + e.getMessage());
        }

        Cv cv = convertXmlToCv(xmlContent);
        System.out.println(cv);
        cvRepository.save(cv);
        return true;
    }

    private Cv convertXmlToCv(String xmlContent) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Cv.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Cv) unmarshaller.unmarshal(new StringReader(xmlContent));
    }

    public boolean deleteCv(Long id) {
        if (cvRepository.existsById(id)) {
            cvRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
