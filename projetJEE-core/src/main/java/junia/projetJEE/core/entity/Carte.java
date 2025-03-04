package junia.projetJEE.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartes")
public class Carte extends GenericEntity {

    private String nom;

    private String imageURL;

    @ManyToOne
    private Donjon donjons;

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

    public void setDonjons(Donjon donjons) {
        this.donjons = donjons;
    }
}
