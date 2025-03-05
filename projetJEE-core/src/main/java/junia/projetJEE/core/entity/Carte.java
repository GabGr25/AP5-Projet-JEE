package junia.projetJEE.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Carte extends GenericEntity {

    private String nom;

    private String imageURL;

    @ManyToOne
    private Donjon donjons;

    public Carte() {
    }

    public Carte(String nom, String imageURL, Donjon donjons) {
        this.nom = nom;
        this.imageURL = imageURL;
        this.donjons = donjons;
    }

    public String getNom() {
        return nom;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Donjon getDonjons() {
        return donjons;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDonjon(Donjon donjons) {
        this.donjons = donjons;
    }
}
