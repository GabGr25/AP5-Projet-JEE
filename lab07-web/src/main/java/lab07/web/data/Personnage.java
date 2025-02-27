package lab07.web.data;

public class Personnage {
    private long id;

    private String nom;

    private String imageURL;

    private Donjon donjon;

    public Personnage() {
    }

    public Personnage(long id, String nom, String imageURL, Donjon donjon) {
        this.id = id;
        this.nom = nom;
        this.imageURL = imageURL;
        this.donjon = donjon;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Donjon getDonjon() {
        return donjon;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDonjon(Donjon donjon) {
        this.donjon = donjon;
    }

    public boolean inDonjon() {
        return this.donjon != null;
    }
}
