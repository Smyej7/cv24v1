package fr.univrouen.cv24v1.models;

import jakarta.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Autre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String titre;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String commentaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Autre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
