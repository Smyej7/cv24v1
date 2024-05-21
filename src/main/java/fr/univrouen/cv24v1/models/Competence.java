package fr.univrouen.cv24v1.models;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String date;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String institut;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String titre;

    @XmlAttribute(namespace = "http://univ.fr/cv24")
    private int niveau;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
