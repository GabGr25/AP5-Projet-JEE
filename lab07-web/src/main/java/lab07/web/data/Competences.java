package lab07.web.data;

public class Competences {
    private long id;

    private String nom;

    private String imageURL;

    private Classes classe;

    public Competences() {
    }

    public Competences(long id, String nom, String imageURL, Classes classe) {
        this.id = id;
        this.nom = nom;
        this.imageURL = imageURL;
        this.classe = classe;
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

    public Classes getClasse() {
        return classe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setClasseId(Classes classe) {
        this.classe = classe;
    }
}
