package junia.projetJEE.core.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personnages")
public class Personnage extends GenericEntity{

    private String nom;
    private String imageURL;
    @ManyToOne
    @Nullable
    private Donjon donjon;

    public String getNom() {
        return nom;
    }

    public String getImageURL() {
        return imageURL;
    }

    @Nullable
    public Donjon getDonjon() {
        return donjon;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDonjon(@Nullable Donjon donjon) {
        this.donjon = donjon;
    }
}
