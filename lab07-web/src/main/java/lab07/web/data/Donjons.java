package lab07.web.data;

public class Donjons {

    private long id;

    private String nom;

    public Donjons() {
    }

    public Donjons(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
