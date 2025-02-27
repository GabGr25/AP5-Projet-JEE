package lab07.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartes")
public class CartesEntity extends GenericEntity {

    private String nom;

    private String imageURL;

    @ManyToOne
    private DonjonsEntity donjons;

    public String getNom() {
        return nom;
    }

    public String getImageURL() {
        return imageURL;
    }

    public DonjonsEntity getDonjons() {
        return donjons;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDonjons(DonjonsEntity donjons) {
        this.donjons = donjons;
    }
}
