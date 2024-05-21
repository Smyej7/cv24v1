package fr.univrouen.cv24v1.models;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class LangueVivante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String lang;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String cert;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String nivs;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private int nivi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getNivs() {
        return nivs;
    }

    public void setNivs(String nivs) {
        this.nivs = nivs;
    }

    public int getNivi() {
        return nivi;
    }

    public void setNivi(int nivi) {
        this.nivi = nivi;
    }
}
