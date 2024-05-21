package fr.univrouen.cv24v1.controllers;

import fr.univrouen.cv24v1.models.*;
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/resume", produces = MediaType.TEXT_HTML_VALUE)
    public String getCvListAsHtml() {
        List<Cv> cvs = cvRepository.findAll();

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>")
                .append("<head><title>Liste des CVs</title><style>")
                .append("body { font-family: Arial, sans-serif; margin: 20px; }")
                .append("table { width: 100%; border-collapse: collapse; }")
                .append("th, td { border: 1px solid #dddddd; padding: 8px; text-align: left; }")
                .append("th { background-color: #f2f2f2; }")
                .append("</style></head>")
                .append("<body>")
                .append("<h1>Liste des CVs</h1>")
                .append("<table>")
                .append("<tr><th>ID</th><th>Identité</th><th>Objectif</th><th>Diplôme</th></tr>");

        for (Cv cv : cvs) {
            htmlBuilder.append("<tr>")
                    .append("<td>").append(cv.getId()).append("</td>")
                    .append("<td>").append(cv.getIdentite()).append("</td>")
                    .append("<td>").append(cv.getObjectif()).append("</td>")
                    .append("<td>").append(cv.getCompetences()).append("</td>")
                    .append("</tr>");
        }

        htmlBuilder.append("</table>")
                .append("</body>")
                .append("</html>");

        return htmlBuilder.toString();
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getCvByIdAsXml(@RequestParam Long id) {
        Optional<Cv> cvOpt = cvRepository.findById(id);
        if (cvOpt.isPresent()) {
            try {
                JAXBContext context = JAXBContext.newInstance(Cv.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                StringWriter sw = new StringWriter();
                marshaller.marshal(cvOpt.get(), sw);
                return sw.toString();
            } catch (JAXBException e) {
                e.printStackTrace();
                return generateErrorMessage(id, "ERROR");
            }
        } else {
            return generateErrorMessage(id, "ERROR");
        }
    }

    private String generateErrorMessage(Long id, String status) {
        return String.format(
                "<error>" +
                        "<id>%d</id>" +
                        "<status>%s</status>" +
                        "</error>",
                id, status
        );
    }

    @GetMapping("/html")
    public String getCvByIdHtml(@RequestParam Long id) {
        Optional<Cv> cvOptional = cvRepository.findById(id);
        if (cvOptional.isPresent()) {
            Cv cv = cvOptional.get();
            return buildHtmlResponse(cv);
        } else {
            return buildErrorResponse(id);
        }
    }

    private String buildHtmlResponse(Cv cv) {
        StringBuilder html = new StringBuilder();
        html.append("<html>")
                .append("<head><title>CV Details</title></head>")
                .append("<body>")
                .append("<h1>CV Details</h1>")
                .append("<p><strong>ID: </strong>").append(cv.getId()).append("</p>")
                .append("<p><strong>Genre: </strong>").append(cv.getIdentite().getGenre()).append("</p>")
                .append("<p><strong>Nom: </strong>").append(cv.getIdentite().getNom()).append("</p>")
                .append("<p><strong>Prénom: </strong>").append(cv.getIdentite().getPrenom()).append("</p>")
                .append("<p><strong>Téléphone: </strong>").append(cv.getIdentite().getTel()).append("</p>")
                .append("<p><strong>Email: </strong>").append(cv.getIdentite().getMel()).append("</p>")
                .append("<p><strong>Objectif: </strong>")
                .append(cv.getStatus()).append(": ")
                .append(cv.getObjectif()).append("</p>")
                .append("<h2>Expérience Professionnelle</h2><ul>");
        for (Experience experience : cv.getProf()) {
            html.append("<li>")
                    .append(experience.getTitre()).append(" (")
                    .append(experience.getDatedeb()).append(" - ")
                    .append(experience.getDatefin()).append(")")
                    .append("</li>");
        }
        html.append("</ul>")
                .append("<h2>Compétences</h2><ul>");
        for (Competence competence : cv.getCompetences()) {
            html.append("<li>")
                    .append(competence.getTitre()).append(" (")
                    .append(competence.getInstitut()).append(", ")
                    .append(competence.getDate()).append(")")
                    .append("</li>");
        }
        html.append("</ul>")
                .append("<h2>Divers</h2><ul>");
        for (LangueVivante lv : cv.getLv()) {
            html.append("<li>Langue: ").append(lv.getLang())
                    .append(", Certificat: ").append(lv.getCert())
                    .append(", Niveau: ").append(lv.getNivs())
                    .append(", Score: ").append(lv.getNivi())
                    .append("</li>");
        }
        for (Autre autre : cv.getAutre()) {
            html.append("<li>").append(autre.getTitre())
                    .append(": ").append(autre.getCommentaire())
                    .append("</li>");
        }
        html.append("</ul>")
                .append("</body>")
                .append("</html>");
        return html.toString();
    }

    private String buildErrorResponse(Long id) {
        return "<html><head><title>Error</title></head><body><h1>Error</h1><p>CV with ID " + id + " not found.</p></body></html>";
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
