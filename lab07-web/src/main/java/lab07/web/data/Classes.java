package lab07.web.data;

public class Classes {
    private long id;

    private String nom;

    private String imageURL;

    public Classes() {
    }

    public Classes(long id, String nom, String imageURL) {
        this.id = id;
        this.nom = nom;
        this.imageURL = imageURL;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
