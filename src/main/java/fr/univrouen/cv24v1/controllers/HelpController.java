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
                "<li>" +
                "<strong>URL:</strong> /<br>" +
                "<strong>Méthode:</strong> GET<br>" +
                "<strong>Résumé:</strong> Affiche la page d'accueil du projet avec les informations de base." +
                "</li>" +
                "<li>" +
                "<strong>URL:</strong> /help<br>" +
                "<strong>Méthode:</strong> GET<br>" +
                "<strong>Résumé:</strong> Affiche cette page d'aide avec les détails des endpoints." +
                "</li>" +
                "<li>" +
                "<strong>URL:</strong> /cv24/resume/xml<br>" +
                "<strong>Méthode:</strong> GET<br>" +
                "<strong>Résumé:</strong> Récupérer la liste des CVs en format XML.<br>" +
                "<strong>Format de retour:</strong> application/xml" +
                "</li>" +
                "<li>" +
                "<strong>URL:</strong> /cv24/resume<br>" +
                "<strong>Méthode:</strong> GET<br>" +
                "<strong>Résumé:</strong> Récupérer la liste des CVs en format HTML.<br>" +
                "<strong>Format de retour:</strong> text/html" +
                "</li>" +
                "<li>" +
                "<strong>URL:</strong> /cv24/xml?id={cv_id}<br>" +
                "<strong>Méthode:</strong> GET<br>" +
                "<strong>Résumé:</strong> Récupérer les détails d'un CV en format XML.<br>" +
                "<strong>Paramètres:</strong> id (numérique, identifiant du CV)<br>" +
                "<strong>Format de retour:</strong> application/xml" +
                "</li>" +
                "<li>" +
                "<strong>URL:</strong> /cv24/html?id={cv_id}<br>" +
                "<strong>Méthode:</strong> GET<br>" +
                "<strong>Résumé:</strong> Récupérer les détails d'un CV en format HTML.<br>" +
                "<strong>Paramètres:</strong> id (numérique, identifiant du CV)<br>" +
                "<strong>Format de retour:</strong> text/html" +
                "</li>" +
                "<li>" +
                "<strong>URL:</strong> /cv24/insert<br>" +
                "<strong>Méthode:</strong> POST<br>" +
                "<strong>Résumé:</strong> Insérer un nouveau CV.<br>" +
                "<strong>Format attendu:</strong> application/xml<br>" +
                "<strong>Format de retour:</strong> application/json" +
                "</li>" +
                "<li>" +
                "<strong>URL:</strong> /cv24/delete?id={cv_id}<br>" +
                "<strong>Méthode:</strong> DELETE<br>" +
                "<strong>Résumé:</strong> Supprimer un CV.<br>" +
                "<strong>Paramètres:</strong> id (numérique, identifiant du CV)<br>" +
                "<strong>Format de retour:</strong> application/json" +
                "</li>" +
                "</ul>" +
                "</body>" +
                "</html>";
    }
}
