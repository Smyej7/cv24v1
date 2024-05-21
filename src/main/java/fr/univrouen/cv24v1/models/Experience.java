package fr.univrouen.cv24v1.models;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement(name = "detail", namespace = "http://univ.fr/cv24")
@XmlAccessorType(XmlAccessType.FIELD)
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String datedeb;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String datefin;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String titre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", datedeb='" + datedeb + '\'' +
                ", datefin='" + datefin + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }
}
