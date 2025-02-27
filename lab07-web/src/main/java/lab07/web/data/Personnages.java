package lab07.web.data;

public class Personnages {
    private long id;

    private String nom;

    private String imageURL;

    private Donjons donjon;

    public Personnages() {
    }

    public Personnages(long id, String nom, String imageURL, Donjons donjon) {
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

    public Donjons getDonjon() {
        return donjon;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDonjon(Donjons donjon) {
        this.donjon = donjon;
    }

    public boolean inDonjon() {
        return this.donjon != null;
    }
}
