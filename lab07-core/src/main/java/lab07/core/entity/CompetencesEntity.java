package lab07.core.entity;

import jakarta.persistence.ManyToOne;

public class CompetencesEntity extends GenericEntity {

    private String nom;

    private String imageURL;

    @ManyToOne
    private ClassesEntity classe;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ClassesEntity getClasse() {
        return classe;
    }

    public void setClasse(ClassesEntity classe) {
        this.classe = classe;
    }
}
