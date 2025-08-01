package junia.projetJEE.core.entity;

import jakarta.persistence.Entity;

@Entity
public class Classe extends GenericEntity {

    private String nom;

    private String imageURL;

    public Classe() {

    }

    public Classe(String nom, String imageURL) {
        this.nom = nom;
        this.imageURL = imageURL;
    }

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
}
