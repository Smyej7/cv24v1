package fr.univrouen.cv24v1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "<html>" +
                "<head>" +
                "<title>Page d'accueil du projet</title>" +
                "</head>" +
                "<body>" +
                "<h1>Bienvenue sur le service de gestion des CVs</h1>" +
                "<p><strong>Nom du projet:</strong> Service de Gestion des CVs</p>" +
                "<p><strong>Numéro de version:</strong> 1.0.0</p>" +
                "<p><strong>Membres de l'équipe:</strong></p>" +
                "<ul>" +
                "<li>Abdelhakim SMYAJ</li>" +
                "</ul>" +
                "<img src='/images/urn-logo.png' alt='Logo de l’Université de Rouen' style='width:200px;height:auto;'/>" +
                "</body>" +
                "</html>";
    }
}
