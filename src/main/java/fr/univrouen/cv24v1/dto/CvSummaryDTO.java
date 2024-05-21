package fr.univrouen.cv24v1.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cvSummary")
@XmlAccessorType(XmlAccessType.FIELD)
public class CvSummaryDTO {

    private Long id;

    @XmlElement(name = "identite")
    private String identite;

    @XmlElement(name = "objectif")
    private String objectif;

    @XmlElement(name = "diplome")
    private String diplome;

    public CvSummaryDTO() {
    }

    public CvSummaryDTO(Long id, String identite, String objectif) {
        this.id = id;
        this.identite = identite;
        this.objectif = objectif;
        this.diplome = diplome;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
}
