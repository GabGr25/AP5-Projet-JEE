package lab07.core.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personnages")
public class PersonnagesEntity extends GenericEntity{

    private String nom;
    private String imageURL;
    @ManyToOne
    @Nullable
    private DonjonsEntity donjon;

    public String getNom() {
        return nom;
    }

    public String getImageURL() {
        return imageURL;
    }

    @Nullable
    public DonjonsEntity getDonjon() {
        return donjon;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDonjon(@Nullable DonjonsEntity donjon) {
        this.donjon = donjon;
    }
}
