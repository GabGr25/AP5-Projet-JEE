package lab07.web.data;

public class Competence {
    private long id;

    private String nom;

    private String imageURL;

    private Classe classe;

    public Competence() {
    }

    public Competence(long id, String nom, String imageURL, Classe classe) {
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

    public Classe getClasse() {
        return classe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setClasseId(Classe classe) {
        this.classe = classe;
    }
}
