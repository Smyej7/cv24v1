package fr.univrouen.cv24v1.models;

import jakarta.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "cv24", namespace = "http://univ.fr/cv24")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "identite_id", referencedColumnName = "id")
    @XmlElement(namespace = "http://univ.fr/cv24")
    private Identite identite;

    @XmlAttribute(namespace = "http://univ.fr/cv24")
    private String status;

    @XmlElement(namespace = "http://univ.fr/cv24")
    private String objectif;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cv_id")
    @XmlElementWrapper(name = "prof", namespace = "http://univ.fr/cv24")
    @XmlElement(name = "detail", namespace = "http://univ.fr/cv24")
    private List<Experience> prof;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cv_id")
    @XmlElementWrapper(name = "competences", namespace = "http://univ.fr/cv24")
    @XmlElements({
            @XmlElement(name = "diplome", type = Competence.class, namespace = "http://univ.fr/cv24"),
            @XmlElement(name = "certif", type = Competence.class, namespace = "http://univ.fr/cv24")
    })
    private List<Competence> competences;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cv_id")
    @XmlElementWrapper(name = "divers", namespace = "http://univ.fr/cv24")
    @XmlElement(name = "lv", namespace = "http://univ.fr/cv24")
    private List<LangueVivante> lv;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cv_id")
    @XmlElementWrapper(name = "divers", namespace = "http://univ.fr/cv24")
    @XmlElement(name = "autre", namespace = "http://univ.fr/cv24")
    private List<Autre> autre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite(Identite identite) {
        this.identite = identite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public List<Experience> getProf() {
        return prof;
    }

    public void setProf(List<Experience> prof) {
        this.prof = prof;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public List<LangueVivante> getLv() {
        return lv;
    }

    public void setLv(List<LangueVivante> lv) {
        this.lv = lv;
    }

    public List<Autre> getAutre() {
        return autre;
    }

    public void setAutre(List<Autre> autre) {
        this.autre = autre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cv{id=").append(id)
                .append(", identite=").append(identite)
                .append(", status='").append(status).append('\'')
                .append(", objectif='").append(objectif).append('\'')
                .append(", prof=").append(prof)
                .append(", competences=").append(competences)
                .append(", lv=").append(lv)
                .append(", autre=").append(autre)
                .append('}');
        return sb.toString();
    }
}
