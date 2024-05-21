package fr.univrouen.cv24v1.controllers;

import fr.univrouen.cv24v1.models.Cv;
import fr.univrouen.cv24v1.repositories.CvRepository;
import fr.univrouen.cv24v1.services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cv24")
public class CvController {

    @Autowired
    private CvService cvService;
    @Autowired
    private CvRepository cvRepository;

    @GetMapping(value = "/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getCvListAsXml() {
        List<Cv> cvs = cvRepository.findAll();
        try {
            JAXBContext context = JAXBContext.newInstance(Cv.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            for (Cv cv : cvs) {
                marshaller.marshal(cv, sw);
            }
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return "<error>Unable to generate XML</error>";
        }
    }

    @GetMapping("/resume")
    public String getAllCvsHtml(Model model) {
        List<Cv> cvs = cvService.getAllCvs();
        model.addAttribute("cvs", cvs);
        return "cvList";
    }

    @GetMapping("/xml")
    public ResponseEntity<Cv> getCvByIdXml(@RequestParam Long id) {
        Optional<Cv> cv = cvService.getCvById(id);
        if (cv.isPresent()) {
            return ResponseEntity.ok(cv.get());
        } else {
            return ResponseEntity.status(404).body(new Cv());
        }
    }

    @GetMapping("/html")
    public String getCvByIdHtml(@RequestParam Long id, Model model) {
        Optional<Cv> cv = cvService.getCvById(id);
        if (cv.isPresent()) {
            model.addAttribute("cv", cv.get());
            return "cvDetail";
        } else {
            model.addAttribute("error", "ID not found");
            return "error";
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertCv(@RequestBody String xmlContent) {
        try {
            boolean success = cvService.addCv(xmlContent);
            if (success) {
                return ResponseEntity.ok("INSERTED");
            } else {
                return ResponseEntity.status(400).body("ERROR: DUPLICATED");
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body("ERROR: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCv(@RequestParam Long id) {
        boolean success = cvService.deleteCv(id);
        if (success) {
            return ResponseEntity.ok("DELETED");
        } else {
            return ResponseEntity.status(404).body("ERROR: ID not found");
        }
    }
}
