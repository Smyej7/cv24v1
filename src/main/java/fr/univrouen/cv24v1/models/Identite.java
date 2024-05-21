package fr.univrouen.cv24v1.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Identite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String genre;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String nom;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String prenom;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String tel;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String mel;

    public Identite() {
    }

    public Identite(String genre, String nom, String prenom, String tel, String mel) {
        this.genre = genre;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mel = mel;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMel() {
        return mel;
    }

    public void setMel(String mel) {
        this.mel = mel;
    }
}
