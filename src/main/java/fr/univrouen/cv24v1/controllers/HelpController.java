package fr.univrouen.cv24v1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelpController {

    @GetMapping("/help")
    public String getHelp() {
        return "<html>" +
                "<body>" +
                "<h1>API Documentation</h1>" +
                "<ul>" +
                "<li><strong>GET /</strong>: Page d'accueil</li>" +
                "<li><strong>GET /help</strong>: Page d'aide avec les détails des endpoints</li>" +
                "<li><strong>GET /cv24/resume/xml</strong>: Récupérer la liste des CVs en format XML</li>" +
                "<li><strong>GET /cv24/resume</strong>: Récupérer la liste des CVs en format HTML</li>" +
                "<li><strong>GET /cv24/xml?id={cv_id}</strong>: Récupérer les détails d'un CV en format XML</li>" +
                "<li><strong>GET /cv24/html?id={cv_id}</strong>: Récupérer les détails d'un CV en format HTML</li>" +
                "<li><strong>POST /cv24/insert</strong>: Insérer un nouveau CV</li>" +
                "<li><strong>DELETE /cv24/delete?id={cv_id}</strong>: Supprimer un CV</li>" +
                "</ul>" +
                "</body>" +
                "</html>";
    }
}
