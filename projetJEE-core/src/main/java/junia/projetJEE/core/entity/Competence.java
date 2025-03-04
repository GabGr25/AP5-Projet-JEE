package junia.projetJEE.core.entity;

import jakarta.persistence.ManyToOne;

public class Competence extends GenericEntity {

    private String nom;

    private String imageURL;

    @ManyToOne
    private Classe classe;

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

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
