package junia.projetJEE.core.entity;

public class Classe extends GenericEntity{

    private String nom;

    private String imageURL;

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
